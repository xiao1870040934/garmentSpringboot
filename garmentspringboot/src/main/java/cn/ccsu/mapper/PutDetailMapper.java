package cn.ccsu.mapper;


import cn.ccsu.entity.PutStoreDetail;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/5 11:09
 * @Version 1.0
 */
public interface PutDetailMapper {
    Integer insert(PutStoreDetail putStoreDetail);

    List<PutStoreDetail> getByPutId(Integer id);
}
