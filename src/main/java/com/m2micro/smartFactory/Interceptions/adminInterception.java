package com.m2micro.smartFactory.Interceptions;

import com.m2micro.smartFactory.constants.PublicConstant;
import com.m2micro.smartFactory.enums.WebResultVoEnum;
import com.m2micro.smartFactory.utils.JsonUtils;
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

        if(request.getSession().getAttribute(PublicConstant.ADMINLOGINKEY) != null){
           return true;
        }
        //JsonUtils.returnJson(response,"{\"code\":\"+ WebResultVoEnum.NOAUTHORITY.getCode() +\",\"\"+WebResultVoEnum.NOAUTHORITY.getMessage()+\"\":\"name is error!\"}");
        return true;
    }
}
