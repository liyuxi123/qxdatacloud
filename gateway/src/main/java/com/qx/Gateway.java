package com.qx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
Author: liYuXi
Date: 11/26/24
Time: 3:05 AM
Package:com.qx
Project:qxdatacloud
功能：
*/

 @SpringBootApplication
 @EnableDiscoveryClient
 public class Gateway {
  public static void main(String[] args) {
   SpringApplication.run(Gateway.class,args);
  }
 }