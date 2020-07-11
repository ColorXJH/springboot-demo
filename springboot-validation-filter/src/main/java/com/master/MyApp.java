package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/10 9:13
 */
@ServletComponentScan//添加servlet-filter扫描注解
@SpringBootApplication
public class MyApp {

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class,args);
    }
}
