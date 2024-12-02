# 微服务基本架构

## 一、nacos服务（版本v2.4.3）

  采取docker部署 nacos官网教程地址https://github.com/nacos-group/nacos-docker/blob/master/README_ZH.md
  注意事项：
   本项目采取的是5.7版本mysql，官网的mysql需要自己初始化数据库，我已经初始化数据库，直接挂载即可
1.    1、挂载目录：打开配置文件/qxdatacloud/nacos-docker/example/.env,将HOST_VOLUME_PATH修改你成你的地址
2.       内容和阿里官网版本v2.4.3模一样，只是修改了cluster-ip.yaml里面的挂载地址
3.    2、在 /qxdatacloud/nacos-docker/下执行命令启动nacos
4.       命令：docker-compose -f example/cluster-ip.yaml -p nacos up

## 二、 gateway
