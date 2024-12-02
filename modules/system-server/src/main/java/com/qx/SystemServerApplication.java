package com.qx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Author: liYuXi
 * Date: 11/26/24
 * Time: 9:14 AM
 * Package:com.qx
 * Project:Default (Template) Project
 * 功能：
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SystemServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemServerApplication.class,args);
    }
}