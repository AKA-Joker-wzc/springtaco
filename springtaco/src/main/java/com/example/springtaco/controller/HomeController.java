package com.example.springtaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller  //控制器
public class HomeController {
    @GetMapping("/") //处理对根路径“/”的请求
    public String home(){
        return "home"; //返回视图名
    }
}
