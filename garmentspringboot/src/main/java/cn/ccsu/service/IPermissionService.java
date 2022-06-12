package cn.ccsu.service;

import cn.ccsu.utils.ResponseResult;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/11 16:10
 * @Version 1.0
 */
public interface IPermissionService {
    ResponseResult getPermissionList(Integer id);

    ResponseResult getMenuList(Integer id);

    ResponseResult doAssign(Integer id, Integer[] permissionId, Integer[] menuId);

    ResponseResult getList();
}
