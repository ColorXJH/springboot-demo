package com.master;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/getName")
    public String doMyName(){
       return "xjh";
    }
}
