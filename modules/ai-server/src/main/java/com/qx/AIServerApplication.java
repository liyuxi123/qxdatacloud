package com.qx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * Author: liYuXi
 * Date: 12/3/24
 * Time: 9:26 AM
 * Package:com.qx
 * Project:qxdatacloud
 * 功能：
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AIServerApplication {
    public static void main(String[] args){
        SpringApplication.run(AIServerApplication.class,args);
    }
}
