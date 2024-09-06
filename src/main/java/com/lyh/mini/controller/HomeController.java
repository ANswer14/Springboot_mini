package com.lyh.mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {



    @GetMapping("/")
    public String goHome() {
        return "home";
    }

    @GetMapping("/home")
    public String goHome2() {
        return "home";
    }



}

