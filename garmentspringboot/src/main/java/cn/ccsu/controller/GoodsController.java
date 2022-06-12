package cn.ccsu.controller;

import cn.ccsu.entity.Goods;
import cn.ccsu.service.IGoodsService;
import cn.ccsu.utils.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/7 8:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/getAll")
    public ResponseResult getAll(String number,String name,Integer pageNum,Integer pageSize){
        return goodsService.getGoodsList(number,name,pageNum,pageSize);
    }
    @GetMapping("/query")
    public ResponseResult pageQuery(Integer pageNum,Integer pageSize){
        return goodsService.queryAll(pageNum,pageSize);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable Integer id){
        return goodsService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public ResponseResult getById(@PathVariable Integer id,@RequestBody Goods goods){
        logger.info("修改id为{}服装信息",id);
        return goodsService.editGoodsById(goods);
    }
}
