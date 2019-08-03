## 启动

1. 拉取项目到本地

   - `git clone xxx.git`

2. 初始化线上数据库

   - 使用线上数据库 `study_service_24484_zyy` ，后面初始化的数据表都会初始化到该数据库中
     - `CREATE DATABASE study_service_24484_zyy;`


   - 运行 `init-local-database.sh` 创建数据表
   - 如果报错 `resources must be a directory` 请修改 `init-local-database.sh 脚本中 -Ddata.dir 属性` 为该项目中 `choerodon-study-service/src/main/resources` 目录在你电脑上的绝对路径

3. 运行项目主函数，启动项目 `choerodon-study-service\src\main\java\io\choerodon\exam\ChoerodonExamApplication.java` 主启动类，注册该服务到线上 Eureka 注册中心

4. 你可以在线上网关（`api-gateway`）配置该项目的路由信息如下

   ```java
   zuul:
     addHostHeader: true
     routes:
       study:
         path: /study-24484/**
         serviceId: CHOERODON-STUDY-SERVICE-24484-ZYY
   ```

5. 运行 `curl.sh` 脚本，进行测试

   - 分别为通过网关路由校验调用 `iam-service` 服务的接口，获取组织、用户信息，以及本地接口获取分行业 project 信息

## 项目介绍

1. 该项目基于 `Choerodon` 编写的一个微服务，启动之后注册到线上 `Eureka` 注册中心；
2. 启动成功之后通过 `Feign` 客户端发起请求，经过路由认证路由后访问 `iam-service` 服务接口返回数据
   - 需要在路由项目中配置当前服务的路由信息，可见**启动**中所述