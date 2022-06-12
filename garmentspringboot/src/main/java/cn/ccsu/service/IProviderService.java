package cn.ccsu.service;

import cn.ccsu.entity.Provider;
import com.github.pagehelper.PageInfo;

/**
 * @Author 潇洒哥queen
 * @Date 2022/5/31 10:02
 * @Version 1.0
 */
public interface IProviderService {
    PageInfo<Provider> getProviderByPage(Integer pageNum,Integer pageSize);
}
