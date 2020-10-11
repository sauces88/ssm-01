package com.sliny.ssm.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date 2020/10/10 21:53
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String globalExceptionHandler(HttpServletRequest request,HttpServletResponse response, Exception ex){
        System.out.println(ex.getMessage());
        return "error.ftl";
    }
}

