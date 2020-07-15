package com.master.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/15 18:18
 */

//@ControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler(Exception.class)
        public String handlerError1(Exception e, RedirectAttributes attributes){
                attributes.addFlashAttribute("name",e.getCause().getMessage());
                return "redirect:/uploadResult";
        }
}
