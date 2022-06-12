package cn.ccsu.mapper;

import cn.ccsu.entity.Goods;
import cn.ccsu.entity.PutStoreDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/5 13:13
 * @Version 1.0
 */
public interface GoodsMapper {
    Goods selectByName(PutStoreDetail putStoreDetail);

    Integer insert(Goods goods);

    Integer modifyById(Goods goods);

    List<Goods> getListByInfo(@Param("name") String name,@Param("number") String number);

    Integer deleteById(Goods goods);

    Goods selectById(Integer id);

    List<Goods> findAll();
}
