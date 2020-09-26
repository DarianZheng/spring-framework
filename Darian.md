#### 细节补充

一、搭建 spring 源码项目的阅读环境需要以下条件
    
    1.1、jdk1.8_265及以上版本：原因可见 https://github.com/spring-projects/spring-framework/wiki/Build-from-Source
    1.2、(可略) gradle环境：https://gradle.org/releases/ (我现在选的是v6.6.1)，下载并配置运行环境

二、fork 一份 spring 源码到自己的仓库：https://github.com/spring-projects/spring-framework/tree/5.2.x
    
    1.1、fork 是方便写了注释什么的好上传上去，不想 fork 的话，直接clone下来你指定文件位置即可
    1.2、修改 clone 下来的 spring 项目的 build.gradle 文件，搜索： repositories
    
    将下面部分的代码粘贴 repositories {} 中，代码如下：
    
    // 新增以下2个阿里云镜像
    maven { url "https://maven.aliyun.com/nexus/content/groups/public/" }
    maven { url "https://maven.aliyun.com/nexus/content/repositories/jcenter" }
    // 新增 spring 插件库
    maven { url "https://repo.spring.io/plugins-release" }
    
三、编译源码，可以查看import-into-idea.md文档的说明

    1.1、 先编译spring-oxm，找到 IDEA 右侧的 Gradle 工具栏（类似Maven），（没找到的可能是没插件或者禁用了）
        gradle 下找到 spring-oxm --> task --> other --> compile TestJava ，运行结果成功就 OK了

四、新建一个模块，用于测试确定环境OK
    
    1.1、点击项目父目录 new Module （Gradle方式，不是Maven），随便创建一个项目
    1.2、随便弄个包（config）再创建个类（JavaConfig）@Configuration @ComponentScan 标识为配置类交给容器管理
        随便再弄个包（po）弄个实体类，再在 JavaConfig 中以 @Bean 声明该对象
    1.3、创建个测试包（test）创建测试类，声明注解编程用的容器 AnnotationConfigApplicationContext
        然后从容器获取你刚才在JavaConfig 以@Bean声明的对象（tostring看看结果）正常即可。                      
        
五、搭建的环境路程中间很多坑
    
    遇到问题你先看看官网或者源码提供地（github）有没有能找到解释问题的地方
    再不然再百度,实在不行你可以试试下面的途径：
    
    1.1、适当的你可以去B站搜索源码搭建的类似视频
    1.2、进入相关的群找人问问
    
PS: 如果你下载了 gradle 的zip，你可以找到项目的 gradle --> wrapper --> gradle-wrapper.properties
   distributionUrl 属性改为： distributionUrl=file:///{gradle的zip包地址}
   
   注释掉默认的 distributionUrl，改自己的本地的，spring项目就不会帮你去下载了（太慢）