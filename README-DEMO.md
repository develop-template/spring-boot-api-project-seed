# README 编写指南
## [如何写一份条理清晰的readme](https://www.toutiao.com/a6693349696359891469/?tt_from=mobile_qq&utm_campaign=client_share&timestamp=1558524393&app=news_article&utm_source=mobile_qq&utm_medium=toutiao_android&req_id=201905221926330100230721945044172&group_id=6693349696359891469)
* 项目简介：用一两句话简单描述该项目所实现的业务功能；
* 技术选型：列出项目的技术栈，包括语言、框架和中间件等；
* 本地构建：列出本地开发过程中所用到的工具命令；
* 领域模型：核心的领域概念，比如对于示例电商系统来说有Order、Product等；
* 测试策略：自动化测试如何分类，哪些必须写测试，哪些没有必要写测试；
* 技术架构：技术架构图；
* 部署架构：部署架构图；
* 外部依赖：项目运行时所依赖的外部集成方，比如订单系统会依赖于会员系统；
* 环境信息：各个环境的访问方式，数据库连接等；
* 编码实践：统一的编码实践，比如异常处理原则、分页封装等；
* FAQ：开发过程中常见问题的解答。

## 项目简介
Spring Boot API Project Seed 是一个基于Spring Boot & MyBatis的种子项目

## 技术选型&文档
- 开发工具 idea,maven
- Spring Boot（[查看Spring Boot学习&使用指南](http://www.jianshu.com/p/1a9fd8936bd8)）
- MyBatis（[查看官方中文文档](http://www.mybatis.org/mybatis-3/zh/index.html)）
- MyBatisb通用Mapper插件（[查看官方中文文档](https://mapperhelper.github.io/docs/)）
- MyBatis PageHelper分页插件（[查看官方中文文档](https://pagehelper.github.io/)）
- Druid Spring Boot Starter（[查看官方中文文档](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter/)）
- Fastjson（[查看官方中文文档](https://github.com/Alibaba/fastjson/wiki/%E9%A6%96%E9%A1%B5)）
- lombok 
- 其他略

## 本地构建
1. 克隆项目
2. 对```test```包内的代码生成器```CodeGenerator```进行配置，主要是JDBC，因为要根据表名来生成代码
3. 如果只是想根据上面的演示来亲自试试的话可以使用```test resources```目录下的```demo-user.sql```，否则忽略该步
3. 输入表名，运行```CodeGenerator.main()```方法，生成基础代码（可能需要刷新项目目录才会出来）
4. 根据业务在基础代码上进行扩展
5. 对开发环境配置文件```application-dev.properties```进行配置，启动项目，Have Fun！

## 领域模型 model
Msg 消息
User 用户

## 模块介绍
```
parent
    common       通用模块,不依赖spring
    boot-common  spring boot 项目通用模块,添加项目初始化器
    provider-api   各个模块api接口 和实体类,推荐目录结构请参考模块下 readme
    serviceA-provider spring boot mybatis 集成(在考虑把这个模块 做成spring boot mybatis starter)
eclipse-java-google-style.xml idea安装Eclipse code formatter 插件 
尽量保持每个模块有各自的readme
```
 
## 开发建议
- 表名，建议使用小写，多个单词使用下划线拼接
- Model内成员变量建议与表字段数量对应，如需扩展成员变量（比如连表查询）建议创建DTO，否则需在扩展的成员变量上加```@Transient```注解，详情见[通用Mapper插件文档说明](https://mapperhelper.github.io/docs/2.use/)
- 建议业务失败直接使用```ServiceException("message")```抛出，由统一异常处理器来封装业务失败的响应结果，比如```throw new ServiceException("该手机号已被注册")```，会直接被封装为```{"code":400,"message":"该手机号已被注册"}```返回，无需自己处理，尽情抛出
- 需要工具类的话建议先从```apache-commons-*```和```guava```中找，实在没有再造轮子或引入类库，尽量精简项目
- 开发规范建议遵循阿里巴巴Java开发手册（[最新版下载](https://github.com/lihengming/java-codes/blob/master/shared-resources/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8CV1.3.0.pdf))
- 建议在公司内部使用[ShowDoc](https://github.com/star7th/showdoc)、[SpringFox-Swagger2](https://github.com/springfox/springfox) 、[RAP](https://github.com/thx/RAP)等开源项目来编写、管理API文档
 