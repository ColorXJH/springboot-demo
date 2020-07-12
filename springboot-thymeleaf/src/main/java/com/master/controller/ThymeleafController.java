package com.master.controller;

import com.master.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/12 12:02
 */
@Controller
public class ThymeleafController {
    Logger logger= LoggerFactory.getLogger(ThymeleafController.class);
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("message","ColorXJHLoveDearBear");
        model.addAttribute("usename","dearbear77");
        model.addAttribute("flag","yes");
        List<User> lists=new ArrayList<>();
        User user1=new User();
        model.addAttribute("habbit","sing");
        user1.setName("ColorXJH");user1.setAge(27);user1.setWeight(130);
        User user2=new User();
        user2.setName("DearBear");user2.setAge(26);user2.setWeight(110);
        lists.add(user1);lists.add(user2);
        model.addAttribute("users",lists);
        return "hello";
    }
}
