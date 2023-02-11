package com.example.spring_study_0.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping("/")
    public String main() {
        System.out.println("index페이지 작동");
        return "pages/index";
    }
}