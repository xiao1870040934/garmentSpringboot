package cn.ccsu.service.impl;

import cn.ccsu.entity.Menu;
import cn.ccsu.entity.Permission;
import cn.ccsu.entity.Role;
import cn.ccsu.enums.AppHttpCodeEnum;
import cn.ccsu.ex.SystemException;
import cn.ccsu.mapper.MenuMapper;
import cn.ccsu.mapper.PermissionMapper;
import cn.ccsu.service.IPermissionService;
import cn.ccsu.utils.ResponseResult;
import cn.ccsu.vo.MenuVo;
import cn.ccsu.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/11 16:11
 * @Version 1.0
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public ResponseResult getPermissionList(Integer id) {
        List<Permission> rolePermissionList=permissionMapper.getByRoleId(id);
        List<Permission> allPermisssionList=permissionMapper.getAll();
        PermissionVo permissionVo=new PermissionVo(allPermisssionList,rolePermissionList);
        return ResponseResult.okResult(permissionVo);
    }

    @Override
    public ResponseResult getMenuList(Integer id) {
        List<Menu> roleMenuList=menuMapper.getByRoleId(id);
        List<Menu> allMenuList=menuMapper.getAll();
        MenuVo menuVo=new MenuVo(allMenuList,roleMenuList);
        return ResponseResult.okResult(menuVo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult doAssign(Integer id, Integer[] permissionId, Integer[] menuId) {
        List<Permission> rolePermissionList=permissionMapper.getByRoleId(id);
        List<Menu> roleMenuList=menuMapper.getByRoleId(id);
        if (roleMenuList.size()!=0){
            Integer result=menuMapper.removeMenus(id);
            if (result!=roleMenuList.size()){
                throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
            }
        }
        if (rolePermissionList.size()!=0){
            Integer result=permissionMapper.removePermission(id);
            if (result!=rolePermissionList.size()){
                throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
            }
        }
        if (permissionId.length!=0){
            Integer rows=permissionMapper.assignRoles(id,permissionId);
            if (rows!=permissionId.length){
                throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
            }
        }
        if (menuId.length!=0){
            Integer rows=menuMapper.assignRoles(id,menuId);
            if (rows!=menuId.length){
                throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
            }
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getList() {
        List<Permission> permissionList=permissionMapper.getAll();
        return ResponseResult.okResult(permissionList);
    }
}
