package cn.ccsu.service;

import cn.ccsu.entity.Goods;
import cn.ccsu.utils.ResponseResult;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/7 8:33
 * @Version 1.0
 */
public interface IGoodsService {
    ResponseResult getGoodsList(String number, String name, Integer pageNum, Integer pageSize);

    ResponseResult deleteById(Integer id);

    ResponseResult editGoodsById(Goods goods);

    ResponseResult queryAll(Integer pageNum, Integer pageSize);
}
