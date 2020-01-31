package com.m2micro.smartFactory.enums;

public enum DisableStatusEnum {
    A("使用"),
    B("禁用");
    private String name;
    DisableStatusEnum(String name){
        this.name = name;
    }
    DisableStatusEnum(){

    }

    public void setName(String name) {
        this.name = name;
    }
}
