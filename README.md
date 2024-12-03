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
 
   
## 二、 gateway
