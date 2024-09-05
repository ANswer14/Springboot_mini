package com.lyh.mini.controller;

import com.lyh.mini.domain.RegisterMemberForm;
import com.lyh.mini.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

    private final MemberService MEMBERSERVICE;

    @Autowired
    public MemberController(MemberService MEMBERSERVICE) {
        this.MEMBERSERVICE = MEMBERSERVICE;
    }

    @GetMapping("/goRegisterController")
    public String goRegisterController(Model model) {
        model.addAttribute("member", new RegisterMemberForm());
        return "member/register";
    }

    @PostMapping("/registerController")
    public String registerController(@Valid @ModelAttribute("member") RegisterMemberForm member, BindingResult bindingResult) {
        if (!member.getPassword1().equals(member.getPassword2())) {
            bindingResult.rejectValue("password2", "notequal", "비밀번호가 틀렸습니다.");
        }

        if (bindingResult.hasErrors()) {
            return "member/register";
        }

        if (MEMBERSERVICE.register(member)) {
            return "member/register";
        }

        return "redirect:/";
    }

    @GetMapping("/goLoginController")
    public String goLoginController() {
        return "member/login";
    }


}
