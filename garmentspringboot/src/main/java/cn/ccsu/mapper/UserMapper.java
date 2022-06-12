package cn.ccsu.mapper;

import cn.ccsu.entity.Provider;
import cn.ccsu.entity.Role;
import cn.ccsu.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/5/30 14:35
 * @Version 1.0
 */
public interface UserMapper {

    User selectByName(String username);

    User getById(Integer userId);

    List<User> getAll();

    Integer insert(User user);

    Integer modifyUser(User user);

    Integer deleteUser(User user);

    Integer updatePassword(User user);

    Integer assignRoles(@Param("userId") Integer userId,@Param("roleId") Integer[] roleId);

    Integer removeRoles(Integer id);
}
