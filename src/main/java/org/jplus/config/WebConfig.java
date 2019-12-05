package org.jplus.config;

import org.jplus.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private UserArgumentResolver userArgumentResolver;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //这里后面默认指的是static里面的文件，后缀为html
        //这里是用的模板引擎，就只能是模板引擎template里面的文件
        registry.addViewController("/").setViewName("Login");
        //registry.addViewController("/practicalteaching").setViewName("practicalteaching");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor); //登陆拦截器
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userArgumentResolver); //User参数解析器
    }
}
