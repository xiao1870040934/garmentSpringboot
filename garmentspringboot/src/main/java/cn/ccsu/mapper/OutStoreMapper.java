package cn.ccsu.mapper;

import cn.ccsu.entity.OutStore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/8 20:32
 * @Version 1.0
 */
public interface OutStoreMapper {
    Integer insert(OutStore outStore);

    Integer insertById(@Param("outId") Integer outSoreId, @Param("detailId") Integer detailId);

    List<OutStore> getOutStoreList(@Param("number") String number,@Param("storage") String storage);

    Integer removeById(OutStore outStore);

    OutStore getById(Integer id);

    Integer modifyOutStore(OutStore outStore);
}
