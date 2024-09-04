package com.lyh.mini.controller;

import com.lyh.mini.domain.Member;
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
    public String goRegisterController() {
        return "member/register";
    }

    @PostMapping("/registerController")
    public String registerController(@Valid RegisterMemberForm member, Model model, BindingResult bindingResult,
                                     @RequestParam("name") String name,
                                     @RequestParam("password1") String password1,
                                     @RequestParam("password2") String password2,
                                     @RequestParam("id") String id) {
        MEMBERSERVICE.register(name, id, password1, password2,  model);
        model.addAttribute("member", member);
        if (bindingResult.hasErrors()) {
            return "member/register";
        }
        return "redirect:/";
    }

    @GetMapping("/goLoginController")
    public String goLoginController() {
        return "member/login";
    }


}
