package com.qx.controller;

import com.qx.service.FeignService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Author: liYuXi
 * Date: 11/26/24
 * Time: 9:41 AM
 * Package:com.qx.controller
 * Project:qxdatacloud
 * 功能：
 */
@RestController
@RefreshScope //支持nacos的动态刷新
public class TestController
{
    @Value("${config.info}")
    private String info;
    @GetMapping("/config/info")
    public String getConfigInfo()
    {
        return info +"--test";
    }


    @Resource
    private FeignService feignService;
    @GetMapping("/openfeign/info")
    public String getOpenfeignInfo(){
     feignService.getOpenfeignInfo();
        return feignService.getOpenfeignInfo();
    }
}