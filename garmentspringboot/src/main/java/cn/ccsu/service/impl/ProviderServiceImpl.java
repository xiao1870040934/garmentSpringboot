package cn.ccsu.service.impl;

import cn.ccsu.entity.Provider;
import cn.ccsu.mapper.ProviderMapper;
import cn.ccsu.service.IProviderService;
import cn.ccsu.utils.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/5/31 10:09
 * @Version 1.0
 */
@Service
public class ProviderServiceImpl implements IProviderService {
    @Autowired
    private ProviderMapper providerMapper;
    @Override
    public PageInfo<Provider> getProviderByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //2.紧跟分页设置的后的第一个select查询会被分页查询
        List<Provider> providers = providerMapper.getAll();
        //3.PageInfo参数navigatepage（导航页，显示的页码）：默认显示5个连续页,页码导航连续显示的页数5
        PageInfo<Provider> pageInfo = new PageInfo<>(providers,5);
        return pageInfo;
    }
}
