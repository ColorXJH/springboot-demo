package com.master.controller;

import com.master.model.OtherBean;
import com.master.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/11 18:38
 */
@RestController
public class NewController {
    //@Resource
    @Autowired
    private UserBean properties;

    @Resource
    private OtherBean other;

    @Value("${colorxjh.name}")
    private String name;
    @GetMapping("/testYML")
    public void testYML(){
        System.out.println(name);
        System.out.println(properties);
        System.out.println(other);
    }
}
