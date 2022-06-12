package cn.ccsu.mapper;

import cn.ccsu.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/11 15:44
 * @Version 1.0
 */
public interface PermissionMapper {
    List<Permission> getByRoleId(Integer id);

    List<Permission> getAll();

    Integer removePermission(Integer id);

    Integer assignRoles(@Param("id") Integer id,@Param("permissionId") Integer[] permissionId);

    List<String> getByUserId(Integer id);
}
