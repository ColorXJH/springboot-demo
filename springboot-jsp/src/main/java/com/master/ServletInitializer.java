package com.master;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.server.Jsp;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/11 22:50
 */
//使用了嵌入式Servlet,默认是不支持jsp
//SpringBootServletInitializer 可以使用外部的Servlet容器

//当然也可以使用8081端口，不使用默认的8080端口，这样可以不用继承SpringBootServletInitializer类
//这个class也就可以删除掉了
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Jsp.class);
    }

    //SpringBootServletInitializer的执行过程，简单来说就是通过SpringApplicationBuilder
    //构建并封装SpringApplication对象，并最终调用SpringApplication的run方法的过程。
}
