package com.bitc.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "index"; // 파일명 앞에 '/' 없어도 됨 기본 templates 밑에 있는 파일로 인식함
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
