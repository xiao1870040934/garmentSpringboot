package cn.ccsu.controller;

import cn.ccsu.entity.OutStore;
import cn.ccsu.entity.PutStore;
import cn.ccsu.service.IStockService;
import cn.ccsu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 潇洒哥queen
 * @Date 2022/6/5 10:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private IStockService stockService;

    @PostMapping("/addInstore")
    @PreAuthorize("hasAuthority('sys:repertory:inhouse')")
    public ResponseResult inStore(@RequestBody PutStore putStore){
        return stockService.inStorage(putStore);
    }

    @PostMapping("/addOutstore")
    @PreAuthorize("hasAuthority('sys:repertory:outhouse')")
    public ResponseResult outStore(@RequestBody OutStore putStore){
        return stockService.outStorage(putStore);
    }

    @GetMapping("/getInstore")
    @PreAuthorize("hasAuthority('sys:repertory:showIn')")
    public ResponseResult getInstore(String addTime,String number,Integer pageNum,Integer pageSize){
        return stockService.getInStore(addTime,number,pageNum,pageSize);
    }

    @GetMapping("/getOutstore")
    @PreAuthorize("hasAuthority('sys:repertory:showOut')")
    public ResponseResult getOutstore(String storage,String number,Integer pageNum,Integer pageSize){
        return stockService.getOutStore(storage,number,pageNum,pageSize);
    }

    @GetMapping("/getInDetail/{id}")
    @PreAuthorize("hasAuthority('sys:repertory:showIn')")
    public ResponseResult getInDetail(@PathVariable Integer id){
        return stockService.getDetail(id);
    }
    @GetMapping("/getOutDetail/{id}")
    @PreAuthorize("hasAuthority('sys:repertory:showOut')")
    public ResponseResult getOutDetail(@PathVariable Integer id){
        return stockService.getOutDetail(id);
    }

    @DeleteMapping("/deleteIn/{id}")
    @PreAuthorize("hasAuthority('sys:repertory:deleteIn')")
    public ResponseResult removeById(@PathVariable Integer id){
        return stockService.removePutStore(id);
    }
    @PreAuthorize("hasAuthority('sys:repertory:deleteOut')")
    @DeleteMapping("/deleteOut/{id}")
    public ResponseResult removeOutById(@PathVariable Integer id){
        return stockService.removeOutStore(id);
    }

    @GetMapping("/getIn/{id}")
    @PreAuthorize("hasAuthority('sys:repertory:showIn')")
    public ResponseResult getPutStore(@PathVariable Integer id){
        return stockService.getPutStoreById(id);
    }

    @PreAuthorize("hasAuthority('sys:repertory:showOut')")
    @GetMapping("/getOut/{id}")
    public ResponseResult getOutStore(@PathVariable Integer id){
        return stockService.getOutStoreById(id);
    }

    @PostMapping("/editIn")
    @PreAuthorize("hasAuthority('sys:repertory:editIn')")
    public ResponseResult editPutStore(@RequestBody PutStore putStore){
        return stockService.editPutStoreById(putStore);
    }

    @PostMapping("/editOut")
    @PreAuthorize("hasAuthority('sys:repertory:editout')")
    public ResponseResult editOutStore(@RequestBody OutStore outStore){
        return stockService.editOutStoreById(outStore);
    }
}
