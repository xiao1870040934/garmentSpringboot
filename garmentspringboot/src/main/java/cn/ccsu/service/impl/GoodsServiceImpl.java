package cn.ccsu.service.impl;

import cn.ccsu.entity.Goods;
import cn.ccsu.entity.User;
import cn.ccsu.enums.AppHttpCodeEnum;
import cn.ccsu.ex.SystemException;
import cn.ccsu.mapper.GoodsMapper;
import cn.ccsu.service.IGoodsService;
import cn.ccsu.utils.BeanCopyUtils;
import cn.ccsu.utils.LoginUserUtils;
import cn.ccsu.utils.ResponseResult;
import cn.ccsu.vo.GoodsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/7 8:36
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public ResponseResult getGoodsList(String number, String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> list=goodsMapper.getListByInfo(name,number);
        PageInfo<Goods> pageInfo = new PageInfo<>(list,5);
        return ResponseResult.okResult(pageInfo);
    }

    @Override
    public ResponseResult deleteById(Integer id) {
        User user= LoginUserUtils.getLoginUser();
        Goods goods=new Goods();
        goods.setUpdateTime(new Date());
        goods.setUpdateBy(user.getUsername());
        goods.setId(id);
        goods.setIsDelete(0);
        Integer rows=goodsMapper.deleteById(goods);
        if (rows!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return null;
    }

    @Override
    public ResponseResult editGoodsById(Goods goods) {
        User logUser= LoginUserUtils.getLoginUser();
        goods.setUpdateTime(new Date());
        goods.setUpdateBy(logUser.getUsername());
        Integer rows=goodsMapper.modifyById(goods);
        if (rows!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> list = goodsMapper.findAll();
        List<GoodsVo> goodsVos = BeanCopyUtils.copyBeanList(list, GoodsVo.class);
        for (int i = 0; i < goodsVos.size(); i++) {
            goodsVos.get(i).setGoodsId(list.get(i).getId());
            goodsVos.get(i).setOutCount(0);
        }
        PageInfo<GoodsVo> goodsPageInfo = new PageInfo<>(goodsVos, 5);
        goodsPageInfo.setTotal(goodsVos.size());
        return ResponseResult.okResult(goodsPageInfo);
    }

}
