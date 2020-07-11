package com.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/11 22:28
 */
@Controller
public class WelcomeController {
    @GetMapping("/useJsp")
    public String welcome(Model model){
         model.addAttribute("time",new Date());
        model.addAttribute("message","hello world!");
        return "welcome";
    }
    @GetMapping("/user")
    public String user(Model model, HttpServletRequest request){
        model.addAttribute("username","ColorXJH");
        model.addAttribute("age",24);
        request.getSession().setAttribute("count",6);
        return "user";
    }
}
