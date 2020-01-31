package com.m2micro.smartFactory.vo;

import com.m2micro.smartFactory.enums.WebResultVoEnum;

import java.io.Serializable;

/*
* api 返回模型
* */
public class WebResultVo   implements Serializable {
    private Integer code = WebResultVoEnum.SUCCESS.getCode();
    private String message = WebResultVoEnum.SUCCESS.getMessage();
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static WebResultVo getInstance(){
        return  new WebResultVo();
    }
    public WebResultVo buildingSuccess(){
        return  this;
    }
    public WebResultVo buildingSuccess(Object data){
        this.data = data;
        return  this;
    }
    public WebResultVo buildingSuccess(String message,Object data){
        this.message = message;
        this.data = data;
        return  this;
    }
    public WebResultVo building(WebResultVoEnum webResultVoEnum){
        this.code = webResultVoEnum.getCode();
        this.message = webResultVoEnum.getMessage();
        this.data = data;
        return  this;
    }

    public WebResultVo building(Integer code , String message){
        this.code = code;
        this.message = message;
        return  this;
    }
    public WebResultVo building(WebResultVoEnum webResultVoEnum,Object data){
        this.code = webResultVoEnum.getCode();
        this.message = webResultVoEnum.getMessage();
        this.data = data;
        return  this;
    }
}
