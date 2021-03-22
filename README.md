# easy-boot-admin

#### 介绍
easy-boot-admin是一个基于springboot快速构建轻量级后台管理平台，由来主要是想搭建一个属于自己的简易框架（尽可能不引入过多的maven依赖），寂寞消遣之作，仅供参考，同时欢迎指点错误与不足。
- 感谢 [layuimi后台管理模板](https://gitee.com/zhongshaofa/layuimini/tree/v2).
- 项目正在逐步优化完善，欢迎关注。

#### 技术栈
springboot+mybatis+Thymeleaf +vue.js + Layui

#### 运行环境
idea(eclipse)/jdk1.8/maven/redis/mysql5.5+

#### 内置功能
1.账号管理： 账号管理主要记录系统的登录账号信息，无用户信息

2.菜单管理： 菜单管理主要用于蒋系统的菜单 按钮 权限标识入口，方便动态设置用户角色权限

3.角色管理： 角色管理，主要管理系统的角色，对角色进行权限授权，精确到按钮级别的控制

4.字典管理：对系统中经常使用的一些较为固定的数据进行维护，如性别，通知类型等

5.操作日志：基于自定义注解加AOP形式实现的操作日志记录功能；

6.定时任务：基于springboot定时任务加反射机制实现的在线（添加、修改、删除)任务调度包含执行结果日志

7.代码生成：基于free mark模板技术实现的代码生成功能，一键生成前后端代码；

8.连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈


#### 安装教程

1.克隆项目

2.导入idea或者eclipse中

3.等待maven项目构建成功

4.修改application.yml中数据库链接信息，初始化sql下的脚本到数据库

5.运行EasyBootAdminApplication.java下的main方法启动程序


#### 使用说明
启动项目，浏览器输入 http://localhost:8080/admin/sys/login 进入登录界面；
管理员用户名密码：admin/123456


#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 运行截图
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005452_5e26c1c6_1208466.png "登录界面.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005558_45a41836_1208466.png "首页.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005522_9691d408_1208466.png "菜单管理.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005534_0723d095_1208466.png "操作日志详情.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005620_029954f1_1208466.png "通知公告.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005637_ff69558a_1208466.png "字典管理.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005656_cb51ab76_1208466.png "文件管理.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005730_28ada6ba_1208466.png "角色管理.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005742_f2f1bda2_1208466.png "定时任务编辑.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005751_c826047d_1208466.png "定时任务.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005807_b4c8dd09_1208466.png "代码生成预览.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0323/005818_53e845fc_1208466.png "SQL监控.png")
