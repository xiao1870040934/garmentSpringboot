package cn.ccsu.controller;


import cn.ccsu.entity.User;
import cn.ccsu.enums.AppHttpCodeEnum;
import cn.ccsu.ex.SystemException;
import cn.ccsu.service.IUserService;
import cn.ccsu.utils.ResponseResult;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @Author 潇洒哥queen
 * @Date 2022/5/30 19:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        return userService.logout();
    }

    @GetMapping("/info")
    public ResponseResult info(){
        return userService.getInfo();
    }

    @GetMapping("/getAll/{pageNum}/{pageSize}")
    @PreAuthorize("hasAuthority('sys:user:select')")
    public ResponseResult getAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        PageInfo<User> pageInfo=userService.getUsersByPage(pageNum,pageSize);
        return ResponseResult.okResult(pageInfo);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys:user:add')")
    public ResponseResult addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('sys:user:select')")
    public ResponseResult getById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('sys:user:modify')")
    public ResponseResult editById(@PathVariable Integer id,@RequestBody User user){
        logger.info("修改id为{}用户信息",id);
        user.setId(id);
        return userService.editUserById(user);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('sys:user:delete')")
    public ResponseResult removeById(@PathVariable Integer id){
        return userService.removeUserById(id);
    }

    @PostMapping("/change")
    public ResponseResult change(@RequestBody Map<String,String> passwordInfo) {
        String oldPassword = passwordInfo.get("oldPassword");
        String newPassword = passwordInfo.get("newPassword");
        if(!StringUtils.hasText(newPassword)){
            throw new SystemException(AppHttpCodeEnum.PARAMETER_ERROR);
        }
        return userService.updatePassword(oldPassword,newPassword);
    }

    @GetMapping("/toAssign/{id}")
    public ResponseResult getRolesById(@PathVariable Integer id){
        return userService.getRoles(id);
    }
    @PostMapping("/doAssign")
    @PreAuthorize("hasAuthority('sys:role:toassign')")
    public ResponseResult doAssign(Integer userId,String roleIds){
        Integer[] roleId = new Integer[0];
        if (!roleIds.equals("")){
            String[]  roles= roleIds.split(",");
            for (String role:roles) {
                System.out.println(role);
            }
            roleId = (Integer[]) ConvertUtils.convert(roles,Integer.class);
        }

        return userService.doAssign(userId,roleId);
    }
}
