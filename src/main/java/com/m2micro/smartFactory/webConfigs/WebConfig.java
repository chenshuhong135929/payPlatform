package com.m2micro.smartFactory.webConfigs;

import com.m2micro.smartFactory.Interceptions.adminInterception;
import com.m2micro.smartFactory.constants.PublicConstant;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Locale;

/*
* web配置类
* */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${fileuploadcomponent.realpath}")
    private String filoadfilesystempath ;
    @Value("${fileuploadcomponent.picture}")
    private String picture;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new adminInterception()).addPathPatterns("/admin/*");
    }

    /*
    对页面的映射
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new LocaleResolver() {
            @Override
            public Locale resolveLocale(HttpServletRequest request) {
                Locale locale = Locale.getDefault();
                Cookie[] cookies = request.getCookies();
                if(cookies != null && cookies.length > 0){
                    for(Cookie cookie : cookies){
                        if(cookie.getName().equals(PublicConstant.USERLOCAL)){
                            String [] localAttr  = cookie.getValue().split("_");
                            locale = new Locale(localAttr[0],localAttr[1]);
                            return  locale;
                        }
                    }
                }
                return locale;
            }

            @Override
            public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

            }
        };

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler( File.separator+picture+"**").addResourceLocations("file:"+filoadfilesystempath+"");//
       // registry.addResourceHandler("/picture/**").addResourceLocations("file:"+ File.separator+"usr"+File.separator+"local"+File.separator+"dockerdome"+File.separator+"rentHouse"+File.separator+"");

    }

    public String getFiloadfilesystempath() {
        return filoadfilesystempath;
    }

    public void setFiloadfilesystempath(String filoadfilesystempath) {
        this.filoadfilesystempath = filoadfilesystempath;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
