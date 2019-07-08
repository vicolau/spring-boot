package com.springboot.web.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LinMingShi
 * @version V1.0
 * @Title: LoginHandlerInterceptor
 * @ProjectName springboot
 * @Description: TODO
 * @date 2019/7/5 11:59
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null){
            //用户未登录，返回登陆页面
            request.setAttribute("msg","用户没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }else{
            return true;
        }
    }


}
