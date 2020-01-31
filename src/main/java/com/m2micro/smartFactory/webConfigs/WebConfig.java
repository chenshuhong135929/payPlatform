package com.m2micro.smartFactory.webConfigs;

import com.m2micro.smartFactory.Interceptions.adminInterception;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
* web配置类
* */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new adminInterception()).addPathPatterns("/admin/*");
    }

}
