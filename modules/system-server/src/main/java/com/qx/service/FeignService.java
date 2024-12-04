package com.qx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: liYuXi
 * Date: 12/3/24
 * Time: 9:39 AM
 * Package:com.qx.service
 * Project:qxdatacloud
 * 功能：外部接口使用
 */

@Component
@FeignClient(value = "qxdata-ai-server")
public interface FeignService {
    @GetMapping("/config/info")
     String getOpenfeignInfo();
}
