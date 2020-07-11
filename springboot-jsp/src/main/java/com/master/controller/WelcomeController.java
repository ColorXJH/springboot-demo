package com.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        }
