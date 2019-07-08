package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class QuickStart {

    @RequestMapping("/quickstart")
    public String quickstart(){
        return "success";
    }
}
