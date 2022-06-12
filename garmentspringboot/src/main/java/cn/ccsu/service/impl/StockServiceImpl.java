package cn.ccsu.service.impl;

import cn.ccsu.entity.*;
import cn.ccsu.enums.AppHttpCodeEnum;
import cn.ccsu.ex.SystemException;
import cn.ccsu.mapper.*;
import cn.ccsu.service.IStockService;
import cn.ccsu.utils.BeanCopyUtils;
import cn.ccsu.utils.LoginUserUtils;
import cn.ccsu.utils.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


/**
 * @Author 潇洒哥queen
 * @Date 2022/6/4 23:15
 * @Version 1.0
 */
@Service
public class StockServiceImpl implements IStockService {

    @Autowired
    private PutStoreMapper putStoreMapper;
    @Autowired
    private OutStoreMapper outStoreMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private PutDetailMapper putDetailMapper;
    @Autowired
    private OutDetailMapper outDetailMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseResult inStorage(PutStore putStore) {
        User user = LoginUserUtils.getLoginUser();
        putStore.setNumber(UUID.randomUUID().toString().replaceAll("-", ""));
        putStore.setCreateTime(new Date());
        putStore.setCreateBy(user.getUsername());
        putStore.setUpdateTime(new Date());
        putStore.setUpdateBy(user.getUsername());
        putStore.setIsDelete(1);
        Integer result=putStoreMapper.insert(putStore);
        if (result!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        Integer id=putStore.getId();
        List<PutStoreDetail> putStoreDetailList=putStore.getDetail();
        if (putStoreDetailList==null){
            throw new SystemException(AppHttpCodeEnum.PARAMETER_ERROR);
        }
        for (int i=0;i<putStoreDetailList.size();i++){
            PutStoreDetail putStoreDetail=putStoreDetailList.get(i);
            Goods goods = goodsMapper.selectByName(putStoreDetail);
            if (goods==null){
                goods = BeanCopyUtils.copyBean(putStoreDetail, Goods.class);
                goods.setCreateTime(new Date());
                goods.setCreateBy(user.getUsername());
                goods.setUpdateBy(user.getUsername());
                goods.setUpdateTime(new Date());
                goods.setNumber("B"+id+i);
                goods.setIsDelete(1);
                Integer row=goodsMapper.insert(goods);
                if (row!=1) {
                    throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
                }
                putStoreDetail.setGoodsId(goods.getId());
            }else {
                goods.setCount(goods.getCount()+putStoreDetail.getCount());
                goods.setUpdateTime(new Date());
                goods.setUpdateBy(user.getUsername());
                Integer rows = goodsMapper.modifyById(goods);
                if (rows!=1){
                    throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
                }
                putStoreDetail.setGoodsId(goods.getId());
            }
            putStoreDetail.setCreateTime(new Date());
            putStoreDetail.setCreateBy(user.getUsername());
            putStoreDetail.setUpdateTime(new Date());
            putStoreDetail.setUpdateBy(user.getUsername());
            Integer result2 = putDetailMapper.insert(putStoreDetail);
            if (result2!=1){
                throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
            }
            Integer rows=putStoreMapper.insertById(id,putStoreDetail.getId());
            if (rows!=1){
                throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
            }
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getInStore(String addTime, String number, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PutStore> list=putStoreMapper.getInStoreList(addTime,number);
        PageInfo<PutStore> pageInfo = new PageInfo<>(list,5);
        return ResponseResult.okResult(pageInfo);
    }

    @Override
    public ResponseResult getDetail(Integer id) {
        List<PutStoreDetail> list=putDetailMapper.getByPutId(id);
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult removePutStore(Integer id) {
        PutStore putStore=new PutStore();
        User user=LoginUserUtils.getLoginUser();
        putStore.setId(id);
        putStore.setUpdateBy(user.getUsername());
        putStore.setUpdateTime(new Date());
        putStore.setIsDelete(0);
        Integer rows=putStoreMapper.removeById(putStore);
        if (rows!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getPutStoreById(Integer id) {
        PutStore putStore=putStoreMapper.getById(id);
        if (putStore==null){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return ResponseResult.okResult(putStore);
    }

    @Override
    public ResponseResult editPutStoreById(PutStore putStore) {
        User logUser= LoginUserUtils.getLoginUser();
        putStore.setUpdateBy(logUser.getUsername());
        putStore.setUpdateTime(new Date());
        Integer rows=putStoreMapper.modifyPutStore(putStore);
        if (rows!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return ResponseResult.okResult();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult outStorage(OutStore outStore) {
        User loginUser = LoginUserUtils.getLoginUser();
        outStore.setCreateBy(loginUser.getUsername());
        outStore.setCreateTime(new Date());
        outStore.setNumber(UUID.randomUUID().toString().replaceAll("-",""));
        outStore.setIsDelete(1);
        outStore.setUpdateTime(new Date());
        outStore.setUpdateBy(loginUser.getUsername());
        Integer integer = outStoreMapper.insert(outStore);
        if (integer!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        Integer id = outStore.getId();
        List<OutStoreDetail> detail = outStore.getDetail();
        for (OutStoreDetail outStoreDetail:detail){
            Integer goodsId = outStoreDetail.getGoodsId();
            Goods goods = goodsMapper.selectById(goodsId);
            if (Objects.isNull(goods)){
                throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
            }
            outStoreDetail.setName(goods.getName());
            outStoreDetail.setColour(goods.getColour());
            outStoreDetail.setSize(goods.getSize());
            outStoreDetail.setColour(goods.getColour());
            outStoreDetail.setCreateTime(new Date());
            outStoreDetail.setCreateBy(loginUser.getUsername());
            outStoreDetail.setUpdateBy(loginUser.getUsername());
            outStoreDetail.setUpdateTime(new Date());
            Integer insert = outDetailMapper.insert(outStoreDetail);
            if (insert!=1){
                throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
            }
            Integer count = outStoreDetail.getOutCount();
            if (count>goods.getCount()){
                throw new SystemException(AppHttpCodeEnum.PARAMETER_ERROR);
            }
            count=goods.getCount()-count;
            goods.setCount(count);
            goods.setUpdateTime(new Date());
            goods.setUpdateBy(loginUser.getUsername());
            Integer integer1 = goodsMapper.modifyById(goods);
            if (integer1!=1){
                throw new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
            }
            Integer insert1 = outStoreMapper.insertById(id,outStoreDetail.getId());
            if (insert1!=1){
                throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
            }
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getOutStore(String storage, String number, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<OutStore> list = outStoreMapper.getOutStoreList(number,storage);
        PageInfo<OutStore> pageInfo = new PageInfo<>(list, 5);
        return ResponseResult.okResult(pageInfo);
    }

    @Override
    public ResponseResult getOutDetail(Integer id) {
        List<OutStoreDetail> list=outDetailMapper.getByOutId(id);
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult removeOutStore(Integer id) {
        OutStore outStore=new OutStore();
        User user=LoginUserUtils.getLoginUser();
        outStore.setId(id);
        outStore.setUpdateBy(user.getUsername());
        outStore.setUpdateTime(new Date());
        outStore.setIsDelete(0);
        Integer rows=outStoreMapper.removeById(outStore);
        if (rows!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getOutStoreById(Integer id) {
        OutStore outStore=outStoreMapper.getById(id);
        if (outStore==null){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return ResponseResult.okResult(outStore);
    }

    @Override
    public ResponseResult editOutStoreById(OutStore outStore) {
        User logUser= LoginUserUtils.getLoginUser();
        outStore.setUpdateBy(logUser.getUsername());
        outStore.setUpdateTime(new Date());
        Integer rows=outStoreMapper.modifyOutStore(outStore);
        if (rows!=1){
            throw new SystemException(AppHttpCodeEnum.RETURN_ERROR);
        }
        return ResponseResult.okResult();
    }
}
