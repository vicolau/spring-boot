package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LinMingShi
 * @version V1.0
 * @Title: HelloWorld
 * @ProjectName springboot
 * @Description: TODO
 * @date 2019/7/2 14:23
 */

@Controller
public class QuickStart {

    @RequestMapping("/quickstart")
    public String quickstart(){
        return "success";
    }
}
