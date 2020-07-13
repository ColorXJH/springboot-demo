package com.master.controller;

import com.master.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
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
    public String index(Model model, HttpServletRequest request, HttpServletResponse response){
        model.addAttribute("message","ColorXJHLoveDearBear");
        model.addAttribute("usename","dearbear77");
        model.addAttribute("flag","yes");
        model.addAttribute("date",new Date());
        List<User> lists=new ArrayList<>();
        User user1=new User();
        model.addAttribute("habbit","sing");
        user1.setName("ColorXJH");user1.setAge(27);user1.setWeight(130);
        User user2=new User();
        model.addAttribute("user1",user1);
        user2.setName("DearBear");user2.setAge(26);user2.setWeight(110);
        lists.add(user1);lists.add(user2);
        model.addAttribute("users",lists);
        request.setAttribute("request","i am a resquest");
        request.getSession().setAttribute("session","i am a session");
        return "hello";
    }
    @GetMapping("/newindex")
    public String newIndex(){
        return "index";
    }
    @GetMapping("/getFragment")
    public String getFragment(){
        return "fragment";
    }

    @RequestMapping("/layout")
    public String layout() {
        return "layout";
    }

    @RequestMapping("/homepage")
    public String home() {
        return "newpage";
    }
}
