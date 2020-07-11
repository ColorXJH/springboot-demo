package com.master.controller;

import com.master.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/9 13:47
 */
@RestController
public class MyController {
    @GetMapping("/getUser")
    public User getUser(){
        User user=new User();
        user.setName("ColorXJH");
        user.setPassword("12345678");
        user.setAge(27);
        return user;
    }
    @GetMapping("/getUserByName")
    public User getUser(User user){
        User user1=new User();
        user1.setAge(user.getAge());
        user1.setPassword(user.getPassword());
        user1.setName(user.getName());
        return user1;
    }
    @GetMapping("/getName/{name}")
    public String getName(@PathVariable String name){
        return "my name is "+name;
    }
}
