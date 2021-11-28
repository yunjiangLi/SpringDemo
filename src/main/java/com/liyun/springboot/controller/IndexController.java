package com.liyun.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   //Spring框架的控制器层注解
public class IndexController {
    @RequestMapping("/index") //表示接收用户请求
    public String index(){
        return "index-page";
    }
}
