package cn.ccsu.service;

import cn.ccsu.utils.ResponseResult;



/**
 * @Author 潇洒哥queen
 * @Date 2022/6/9 10:30
 * @Version 1.0
 */
public interface IRoleService {
    ResponseResult getAll(Integer pageNum, Integer pageSize);
}
