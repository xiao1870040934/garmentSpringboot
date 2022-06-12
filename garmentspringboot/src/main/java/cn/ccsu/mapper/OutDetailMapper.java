package cn.ccsu.mapper;

import cn.ccsu.entity.OutStoreDetail;
import cn.ccsu.entity.PutStoreDetail;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/8 20:48
 * @Version 1.0
 */
public interface OutDetailMapper {
    Integer insert(OutStoreDetail outStoreDetail);

    List<OutStoreDetail> getByOutId(Integer id);
}
