package cn.ccsu.service.impl;

import cn.ccsu.entity.Role;
import cn.ccsu.entity.User;
import cn.ccsu.mapper.RoleMapper;
import cn.ccsu.service.IRoleService;
import cn.ccsu.utils.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/9 10:31
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ResponseResult getAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roles = roleMapper.getAll();
        PageInfo<Role> pageInfo = new PageInfo<>(roles,5);
        return ResponseResult.okResult(pageInfo);
    }
}
