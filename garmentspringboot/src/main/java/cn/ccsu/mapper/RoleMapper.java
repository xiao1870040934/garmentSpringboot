package cn.ccsu.mapper;

import cn.ccsu.entity.Role;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/9 10:33
 * @Version 1.0
 */
public interface RoleMapper {
    List<Role> getAll();

    List<Role> getRoles(Integer id);

    List<String> getRolesKey(Integer id);
}
