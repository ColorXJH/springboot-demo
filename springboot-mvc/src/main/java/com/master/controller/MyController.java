package com.master.controller;

import com.master.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/9 13:47
 */
@RestController
public class MyController {
    private Logger log= LoggerFactory.getLogger(MyController.class);
    @GetMapping("/getUser")
    public User getUser(){
        log.info("打印输出日志1111"+new Date());
        User user=new User();
        user.setName("ColorXJH");
        user.setPassword("12345678");
        user.setAge(27);
        return user;
    }

    @GetMapping("/getUserByName")
    public User getUser(User user){
        log.info("打印输出日志1222"+new Date());
        User user1=new User();
        user1.setAge(user.getAge());
        user1.setPassword(user.getPassword());
        user1.setName(user.getName());
        return user1;
    }
    @GetMapping("/getName/{name}")
    public String getName(@PathVariable String name){
        log.info("打印输出日志333"+new Date());
        return "my name is "+name;
    }
}
