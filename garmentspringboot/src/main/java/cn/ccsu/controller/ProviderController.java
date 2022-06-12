package cn.ccsu.controller;

import cn.ccsu.entity.Provider;
import cn.ccsu.service.IProviderService;
import cn.ccsu.utils.ResponseResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 潇洒哥queen
 * @Date 2022/5/31 9:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private IProviderService providerService;
    @GetMapping("/getAll/{pageNum}/{pageSize}")
    public ResponseResult getAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        PageInfo<Provider> pageInfo=providerService.getProviderByPage(pageNum,pageSize);
        return ResponseResult.okResult(pageInfo);
    }
}
