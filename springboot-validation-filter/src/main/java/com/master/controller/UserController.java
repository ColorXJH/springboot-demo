package com.master.controller;

import com.master.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/10 9:13
 */
@RestController
public class UserController {

    //validate 验证
    @GetMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result){
        System.out.println("user:"+user);
        if(result.hasErrors()){
            System.out.println("has errors: ");
            List<ObjectError> errors=result.getAllErrors();
            for (ObjectError error:errors){
                System.out.println(error.getCode()+"---------"+error.getDefaultMessage());
            }
        }
    }

}
