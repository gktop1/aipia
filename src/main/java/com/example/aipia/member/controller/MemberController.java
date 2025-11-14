package com.example.aipia.member.controller;

import com.example.aipia.common.exception.CustomException;
import com.example.aipia.member.dto.MemberRegisterRequest;
import com.example.aipia.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/member")
public class MemberController {

    private MemberService memberService;

    @PostMapping("/register")
    public String registerMember(@Valid MemberRegisterRequest request) {
        memberService.registerMember(request);

        return "SUCCESS";
    }

    @PostMapping("/login")
    public String login() {
        String loginId = "";
        String password = "";
        try {
            return memberService.loginMember(loginId, password).toString();
        } catch (CustomException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "서버에 알수없는 오류 발생";
        }
    }

}
