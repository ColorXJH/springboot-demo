package com.master.configuration;

import com.master.filter.GenerateFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/11 17:19
 */
//传统的过滤器配置不需要再启动类上加注解@ServletComponentScan
@Configuration
public class MyConfiguration {
    @Bean
    public FilterRegistrationBean<GenerateFilter> filterRegistrationBean(){
        //新建过滤器注册类
        FilterRegistrationBean<GenerateFilter> registrationBean=new FilterRegistrationBean<>();
        //添加自定义过滤器
        registrationBean.setFilter(generateFilter());
        //设置过滤器的url模式
        registrationBean.addUrlPatterns("/*");
        //设置过滤器顺序，order值越小，优先级越高
        registrationBean.setOrder(1);

        return registrationBean;
    }
    @Bean
    public GenerateFilter generateFilter(){
        return new GenerateFilter();
    }


}
