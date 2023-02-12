package com.example.spring_study_0.controller;


import com.example.spring_study_0.Dto.MemberFormDto;
import com.example.spring_study_0.entity.Member;
import com.example.spring_study_0.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@RequestMapping(value="/test", method = {RequestMethod.GET, RequestMethod.POST})
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final PasswordEncoder passwordEncoder;

    private final MemberService memberService;




    @PostMapping("/register")
    public String memberForm(@Valid MemberFormDto memberFormDto,
                             BindingResult bindingResult, Model model) {
        System.out.println("postmapping register");

        System.out.println("============>"+memberFormDto);

        if(bindingResult.hasErrors()) {
            return "member/memberForm";
        }

        try {
            Member createMember = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(createMember);
        } catch(IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            System.out.println("회원가입 중복발생");
            return "member/memberForm";
        }

        model.addAttribute("successRegister","회원가입에 성공했습니다. 로그인해주세요");

        return "redirect:/";
    }

    @GetMapping(value="/login")
    public String loginMember(){
        return "member/memberLogin";
    }

    @GetMapping(value="/login/error")
    public String loginMember(Model model){
        model.addAttribute("loginErrorMsg","아이디 또는 비밀번호를 확인해주세요");
        return "member/memberLogin";
    }




}

