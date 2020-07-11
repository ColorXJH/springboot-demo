package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/11 22:35
 */
//注意该项目不要使用项目右击run/debug 在控制台cmd进入 cd..\springboot-jsp 执行命令mvn clean spring-boot run
// 或者在idea右边的maven中找到plugin 找到其中的spring-boot 选择spring-boot:run运行

//如果想在main中运行该项目，则在pom.xml的build标签中指定resources,详情见pom.xml
//或者是在该项目下edit-configuration选项，打开run/debug的configuration,在enviroment项中找到working directory选项
//设置该项为项目根路径（或者$MODULE_WORKING_DIR$），重启项目即可（和pom.xml二选一）

@SpringBootApplication
public class JspApp {

    public static void main(String[] args) {
        SpringApplication.run(JspApp.class,args);
    }
}



//在单独的tomcat中运行，
    //1：在pom.xml中将打包格式改为war
    //2:排除内嵌的tomcat
    /*<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <!-- 排除内置容器器，排除内置容器器导出成 war 包可以让外部容器器运⾏行行spring-boot项⽬目-->
        <exclusions>
            <exclusion>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-tomcat</artifactId>
            </exclusion>
        </exclusions>
    </dependency>*/
    //3:servlet的支持
        //springboot项目必须实先SpringBootServletInitializer接口的configure方法，才能让外部容器
        //运行自己的servlet容器，而不是构建springboot内见的servlet容器
            /*public class ServletInitializer extends SpringBootServletInitializer{
                    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
                        return  application.sources(JspApp.class);
                    }
            }*/
     //4:打包发布
        //在根目录执行：mvn clean package
     //5:将war包发布到tomcat即可

//springboot支持使用内嵌的tomcat运行jsp,也支持将项目打包成war包部署到独立的tomcat
//实际项目中推荐使用独立的tomcat来部署jsp项目，内嵌的tomcat还不是很稳定，会出现访问延迟的现象。