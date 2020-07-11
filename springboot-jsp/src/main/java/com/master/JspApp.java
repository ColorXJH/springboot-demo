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

@SpringBootApplication
public class JspApp {

    public static void main(String[] args) {
        SpringApplication.run(JspApp.class,args);
    }
}
