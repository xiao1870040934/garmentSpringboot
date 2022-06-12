package cn.ccsu.controller;

import cn.ccsu.service.IRoleService;
import cn.ccsu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/9 10:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping("/getList/{pageNum}/{pageSize}")
    public ResponseResult getList(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
       return roleService.getAll(pageNum,pageSize);
    }
}
