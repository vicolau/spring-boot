package com.springboot.web.config;

import com.springboot.web.component.LoginHandlerInterceptor;
import com.springboot.web.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /vico 请求 也来到success页面
        registry.addViewController("/vico").setViewName("success");
        registry.addViewController("/main.html").setViewName("test");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludeUrl = new String[]{"/","/index.html","/user/login","/static/**"};
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(excludeUrl);
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
