package com.example.spring_study_0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController

public class SpringStudy0Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringStudy0Application.class, args);
    }
    @GetMapping( value="/")
    public String test(){
        return "testasssssss2222222";
    }

}
