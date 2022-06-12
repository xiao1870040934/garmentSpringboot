package cn.ccsu.service;

import cn.ccsu.entity.OutStore;
import cn.ccsu.entity.PutStore;
import cn.ccsu.utils.ResponseResult;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/4 23:15
 * @Version 1.0
 */
public interface IStockService {
    ResponseResult inStorage(PutStore putStore);

    ResponseResult getInStore(String addTime, String number, Integer pageNum, Integer pageSize);

    ResponseResult getDetail(Integer id);

    ResponseResult removePutStore(Integer id);

    ResponseResult getPutStoreById(Integer id);

    ResponseResult editPutStoreById(PutStore putStore);

    ResponseResult outStorage(OutStore outStore);

    ResponseResult getOutStore(String storage, String number, Integer pageNum, Integer pageSize);

    ResponseResult getOutDetail(Integer id);

    ResponseResult removeOutStore(Integer id);

    ResponseResult getOutStoreById(Integer id);

    ResponseResult editOutStoreById(OutStore outStore);
}
