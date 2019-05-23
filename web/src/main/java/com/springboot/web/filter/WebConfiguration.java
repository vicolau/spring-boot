package com.springboot.web.filter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Configuration
public class WebConfiguration {

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new FirstFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName","paramValue");
        registration.setName("FirstFilter");
        registration.setOrder(1);
        return  registration;
    }

    public class FirstFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest seRequest, ServletResponse seResponse, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest)seRequest;
            System.out.println("url: " + request.getRequestURI());
            chain.doFilter(seRequest,seResponse);
            
        }

        @Override
        public void destroy() {

        }
    }
}
