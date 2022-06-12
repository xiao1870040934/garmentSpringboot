package cn.ccsu.service.impl;

import cn.ccsu.entity.LoginUser;
import cn.ccsu.entity.User;
import cn.ccsu.ex.SystemException;
import cn.ccsu.mapper.PermissionMapper;
import cn.ccsu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author 潇洒哥queen
 * @Date 2022/5/30 14:34
 * @Version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.selectByName(username);
        //判断是否查到用户  如果没查到抛出异常

        if(Objects.isNull(user)){
            throw new SystemException("用户不存在");
        }
        //返回用户信息
        List<String> list=permissionMapper.getByUserId(user.getId());
        LoginUser loginUser=new LoginUser(user);
        loginUser.setPermissions(list);
        return loginUser;
    }
}
