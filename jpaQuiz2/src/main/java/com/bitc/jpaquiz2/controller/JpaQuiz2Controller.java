package com.bitc.jpaquiz2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class JpaQuiz2Controller {

    @RequestMapping("/")
    public String index() throws Exception {

        return "success";
    }

    @RequestMapping("/quiz2")
    public String quiz2() throws Exception {

        return "quiz2 success";
    }
}
