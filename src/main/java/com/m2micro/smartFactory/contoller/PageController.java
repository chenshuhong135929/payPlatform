package com.m2micro.smartFactory.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController extends  BaseController {
    @RequestMapping({"/login","/login.html"})
    public  String  login(){
        return "login";
    }
    /*
    去首页
     */
    @RequestMapping({"/index","/index.html"})
    public  String  index(){
        return "index";
    }
}
