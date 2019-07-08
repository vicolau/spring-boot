package com.springboot.web.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author LinMingShi
 * @version V1.0
 * @Title: LoginController
 * @ProjectName springboot
 * @Description: TODO
 * @date 2019/7/5 10:58
 */

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Map<String,Object> map, HttpSession httpSession){
        if(Strings.isNotBlank(username) && "123456".equals(password)){
            httpSession.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg", "密码错误");
            return "login";
        }
    }
}
