package com.m2micro.smartFactory.Interceptions;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
* 超级管理员登录部分拦截器
* */
public class adminInterception  extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("请求url路径=="+request.getRequestURI());
        return true;
    }
}
