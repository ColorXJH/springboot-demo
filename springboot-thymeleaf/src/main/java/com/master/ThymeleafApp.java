package com.master;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/12 12:01
 */
@SpringBootApplication
public class ThymeleafApp {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApp.class,args);
    }


    //多文件上传时
    //tomcat large file upload  connect reset
    //了解决上传⽂文件⼤大于 10M 出现连接重置的问题,此异常内容 GlobalException 也捕获不不到。
    public TomcatServletWebServerFactory tomcatEmbeded(){
        TomcatServletWebServerFactory tomcat=new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector->{
            if((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)){
                ((AbstractHttp11Protocol<?>)connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }
}
