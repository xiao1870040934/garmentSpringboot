package cn.ccsu.utils;

import cn.ccsu.entity.LoginUser;
import cn.ccsu.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/2 16:38
 * @Version 1.0
 */
public class LoginUserUtils {
    public static User getLoginUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return loginUser.getUser();
    }
}
