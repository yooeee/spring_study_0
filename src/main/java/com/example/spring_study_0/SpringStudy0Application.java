package com.example.spring_study_0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringStudy0Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringStudy0Application.class, args);
    }
    @GetMapping(value = "/")
    public String index(){
        return "pages/index";
    }

    @GetMapping(value = "/member")
    public String index2(){
        return "member/memberForm";
    }





}


