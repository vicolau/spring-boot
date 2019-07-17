package com.springboot.web.config;

import com.springboot.web.component.LoginHandlerInterceptor;
import com.springboot.web.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 配置映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /vico 请求 也来到success页面
        registry.addViewController("/vico").setViewName("success");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 配置拦截路径
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // excludeUrl 白名单
//        String[] excludeUrl = new String[]{"/","/index.html","/user/login","/asserts/**","/webjars/**"};
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns(excludeUrl);
    }

    /**
     * 配置资源文件路径  默认是/**
     * 也可以在配置文件中采用 spring.mvc.static-path-pattern 属性进行配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
