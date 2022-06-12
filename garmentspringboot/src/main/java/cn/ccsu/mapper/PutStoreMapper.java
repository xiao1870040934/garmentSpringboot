package cn.ccsu.mapper;


import cn.ccsu.entity.PutStore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/5 11:08
 * @Version 1.0
 */
public interface PutStoreMapper {
    Integer insert(PutStore putStore);

    Integer insertById(@Param("putId") Integer putSoreId,@Param("detailId") Integer detailId);

    List<PutStore> getInStoreList(@Param("addTime")String addTime,@Param("number") String number);

    Integer removeById(PutStore putStore);

    PutStore getById(Integer id);

    Integer modifyPutStore(PutStore putStore);
}
