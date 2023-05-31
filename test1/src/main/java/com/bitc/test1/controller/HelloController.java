package com.bitc.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return  "index";
    }
    @RequestMapping("/test1")
    public String test1() {
        return "test1";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    public String test2() {
        return "test2";
    }

    // @GetMapping도 있음, test2를 이렇게 표현 할수도 있음
    @PostMapping("/test3")
    public String test3() {
        return "test3";
    }
}
