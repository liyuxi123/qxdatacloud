# 微服务基本架构

## 一、nacos服务（版本v2.4.3）
  采取docker部署 nacos官网教程地址[https://github.com/nacos-group/nacos-docker/blob/master/README_ZH.md]
  注意事项：
   本项目采取的是5.7版本mysql，官网的mysql需要自己初始化数据库，我已经初始化数据库，直接挂载即可
   内容和阿里官网版本v2.4.3模一样，只是修改了cluster-ip.yaml里面的挂载地址和增加了nginx代理
   1. 挂载目录：打开配置文件/qxdatacloud/nacos-docker/example/.env,将HOST_VOLUME_PATH修改你成你的地址
   2. /qxdatacloud/nacos-docker/下执行命令启动nacos 命令：
   3. `docker-compose -f example/cluster-ip.yaml -p nacos up`
   4. nginx代理集群，统一转发1111端口（可选）,配置文件/qxdatacloud/nacos-docker/nginx/nginx.conf
      nacos2.1.1版本之后需要grpc协议配置（TCP长连接）
      nacos登录地址（无d用户名和密码）： http://127.0.0.1:1111/nacos/
## 二、 gateway服务
     1、如何整合各个自服务地址统一端口地址对外
     2、如何负载均衡

## 三、modules服务
     1、子服务之间如何通过openfeign与loadbalancer互相调用
       <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-loadbalancer</artifactId>
        </dependency>
## 四、common公共模块
     1、如何构造common模块
     2、如何引入common模块

     

   
