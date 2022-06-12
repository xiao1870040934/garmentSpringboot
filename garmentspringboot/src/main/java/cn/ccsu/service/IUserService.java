package cn.ccsu.service;

import cn.ccsu.entity.Provider;
import cn.ccsu.entity.User;
import cn.ccsu.utils.ResponseResult;
import com.github.pagehelper.PageInfo;

/**
 * @Author 潇洒哥queen
 * @Date 2022/5/30 19:25
 * @Version 1.0
 */
public interface IUserService {
    ResponseResult login(User user);

    ResponseResult logout();

    ResponseResult getInfo();

    PageInfo<User> getUsersByPage(Integer pageNum, Integer pageSize);

    ResponseResult addUser(User user);

    ResponseResult getUserById(Integer id);

    ResponseResult editUserById(User user);

    ResponseResult removeUserById(Integer id);

    ResponseResult updatePassword(String oldPassword, String newPassword);

    ResponseResult getRoles(Integer id);

    ResponseResult doAssign(Integer userId, Integer[] roleIds);
}
