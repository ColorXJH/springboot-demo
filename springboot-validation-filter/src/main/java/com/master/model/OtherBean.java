package com.master.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/11 19:14
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "other")
@PropertySource("classpath:myapplication.properties")
public class OtherBean {
    private String name;
    private int age;
}
