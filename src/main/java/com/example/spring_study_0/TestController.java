package com.example.spring_study_0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value ="/test")
    public UserDto test() {
        UserDto userDto = new UserDto();
        userDto.setAge(20);
        userDto.setName("Hello");

        return userDto;

    }
}
