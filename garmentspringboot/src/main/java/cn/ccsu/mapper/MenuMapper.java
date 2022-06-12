package cn.ccsu.mapper;

import cn.ccsu.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/9 8:49
 * @Version 1.0
 */
public interface MenuMapper {
    List<String> getRoutesByUserId(Integer id);

    List<Menu> getByRoleId(Integer id);

    List<Menu> getAll();

    Integer removeMenus(Integer id);

    Integer assignRoles(@Param("id") Integer id,@Param("menuId") Integer[] menuId);
}
