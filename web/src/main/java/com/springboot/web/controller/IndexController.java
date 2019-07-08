package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LinMingShi
 * @version V1.0
 * @Title: HelloController
 * @ProjectName springboot
 * @Description: TODO
 * @date 2019/7/4 17:34
 */
@Controller
public class IndexController {

    @RequestMapping({"/","/index.html"})
    public String index(){
        return "login";
    }

}
