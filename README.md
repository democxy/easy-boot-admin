# springboot-api-demo

#### 介绍
springboot-api-demo是一个基于springboot快速构建api的脚手架项目，由来主要是想搭建一个属于自己的简易框架，寂寞消遣之作，仅供参考，同时欢迎指点错误与不足。


#### 安装教程

1.克隆项目

2.导入idea或者eclipse中

3.等待maven项目构建成功

4.修改application.yml中数据库链接信息，初始化sql下的脚本到数据库

5.运行SpringbootApiDemoApplication.java下的main方法启动程序


#### 使用说明

程序启动成功后可以直接浏览器输入：http://localhost:8080/admin/account/get/1 访问，正常响应结果如下：

{"code":4040,"msg":"登录失败！","data":"token过期，请重新登录"}

结果正常，说明系统正常运行起来了，可以使用接口测试工具（postman,restman,soapui等）开始测试接口；

 **请先通过登录接口获取请求token再进行其他接口的测试。** 

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
