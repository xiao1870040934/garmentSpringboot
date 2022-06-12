package cn.ccsu.service.impl;

import cn.ccsu.entity.LoginUser;
import cn.ccsu.entity.Role;
import cn.ccsu.entity.User;
import cn.ccsu.enums.AppHttpCodeEnum;
import cn.ccsu.ex.SystemException;
import cn.ccsu.mapper.MenuMapper;
import cn.ccsu.mapper.RoleMapper;
import cn.ccsu.mapper.UserMapper;
import cn.ccsu.service.IUserService;
import cn.ccsu.utils.JwtUtil;
import cn.ccsu.utils.LoginUserUtils;
import cn.ccsu.utils.RedisCache;
import cn.ccsu.utils.ResponseResult;
import cn.ccsu.vo.RoleVo;
import cn.ccsu.vo.UserInfo;
import cn.ccsu.vo.UserLoginInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author 潇洒哥queen
 * @Date 2022/5/30 19:26
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断是否认证通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //把用户信息存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);
        UserLoginInfoVo vo = new UserLoginInfoVo(jwt);
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult logout() {
        //获取token 解析获取userid
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        //获取userid
        Integer userId = loginUser.getUser().getId();
        //删除redis中的用户信息
        redisCache.deleteObject("login:"+userId);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        //获取userid
        //Integer userId = loginUser.getUser().getId();
        //User user=userMapper.getById(userId);
        UserInfo userInfo=new UserInfo(loginUser.getUsername());
        List<String> list=menuMapper.getRoutesByUserId(loginUser.getUser().getId());
        List<String> roleList=roleMapper.getRolesKey(loginUser.getUser().getId());
        userInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfo.setRoutes(list);
        userInfo.setRoles(roleList);
        return ResponseResult.okResult(userInfo);
    }

    @Override
    public PageInfo<User> getUsersByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.getAll();
        for (User user:users) {
            user.setPassword(null);
            user.setCreateTime(null);
            user.setCreateBy(null);
            user.setIsDelete(null);
        }
        PageInfo<User> pageInfo = new PageInfo<>(users,5);
        return pageInfo;
    }

    @Override
    public ResponseResult addUser(User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userId = loginUser.getUser().getId();
        String encode = passwordEncoder.encode("123456");
        String logName=userMapper.getById(userId).getUsername();
        user.setPassword(encode);
        user.setCreateBy(logName);
        user.setCreateTime(new Date());
        user.setUpdateBy(logName);
        user.setUpdateTime(new Date());
        user.setIsDelete(1);
        Integer rows=userMapper.insert(user);
        if (rows!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getUserById(Integer id) {
        User user=userMapper.getById(id);
        if (user==null){
            throw new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
        }
        user.setPassword(null);
        user.setCreateTime(null);
        user.setUpdateTime(null);
        user.setCreateBy(null);
        user.setCreateTime(null);
        user.setIsDelete(null);
        return ResponseResult.okResult(user);
    }

    @Override
    public ResponseResult editUserById(User user) {
        User logUser= LoginUserUtils.getLoginUser();
        user.setUpdateTime(new Date());
        user.setUpdateBy(logUser.getUsername());
        Integer rows=userMapper.modifyUser(user);
        if (rows!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult removeUserById(Integer id) {
        User logUser= LoginUserUtils.getLoginUser();
        User user=new User();
        user.setId(id);
        user.setUpdateTime(new Date());
        user.setUpdateBy(logUser.getUsername());
        user.setIsDelete(0);
        Integer rows=userMapper.deleteUser(user);
        if (rows!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult updatePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(newPassword)){
            throw new SystemException(AppHttpCodeEnum.MODIFY_ERROR);
        }
        User user = LoginUserUtils.getLoginUser();
        if(!passwordEncoder.matches(oldPassword, user.getPassword())){
            throw new SystemException(AppHttpCodeEnum.PASSWORD_ERROR);
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setUpdateBy(user.getUsername());
        user.setUpdateTime(new Date());
        Integer rows = userMapper.updatePassword(user);
        if (rows!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getRoles(Integer id) {
        List<Role> userRoleList=roleMapper.getRoles(id);
        List<Role> allRoleList=roleMapper.getAll();
        RoleVo roleVo=new RoleVo(allRoleList,userRoleList);
        return ResponseResult.okResult(roleVo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult doAssign(Integer userId, Integer[] roleIds) {
        List<Role> userRoleList=roleMapper.getRoles(userId);
        if (userRoleList.size()!=0){
            //oldRoleIds=userRoleList.stream().map(Role::getId).collect(Collectors.toList());
            Integer result=userMapper.removeRoles(userId);
            if (result==0){
                throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
            }
        }
        if(roleIds.length!=0){
            Integer rows=userMapper.assignRoles(userId,roleIds);
            if (rows!=roleIds.length){
                throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
            }
        }

        return ResponseResult.okResult();
    }
}
