package cn.ccsu.controller;

import cn.ccsu.service.IPermissionService;
import cn.ccsu.utils.ResponseResult;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/11 15:42
 * @Version 1.0
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    @GetMapping("/toAssign/{id}")
    public ResponseResult toAssign(@PathVariable Integer id){
        return permissionService.getPermissionList(id);
    }
    @GetMapping("/menu/{id}")
    public ResponseResult toAssignMenu(@PathVariable Integer id){
        return permissionService.getMenuList(id);
    }
    @PostMapping("/doAssign/{id}")
    @PreAuthorize("hasAuthority('sys:permission:toassign')")
    public ResponseResult doAssign(@PathVariable Integer id,String permissionIds,String menuIds){
        Integer[] permissionId =new Integer[0];
        Integer[] menuId =new Integer[0];
        if (!permissionIds.equals("")){
            String[] permissions=permissionIds.split(",");
            permissionId=(Integer[]) ConvertUtils.convert(permissions,Integer.class);
        }
        if (!menuIds.equals("")){
            String[] menus=menuIds.split(",");
            menuId=(Integer[]) ConvertUtils.convert(menus,Integer.class);
        }
        return permissionService.doAssign(id,permissionId,menuId);
    }
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:menu:select')")
    public ResponseResult getPermissionList(){
        return permissionService.getList();
    }
}
