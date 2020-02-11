package com.m2micro.smartFactory.enums;

public enum DisableStatusEnum {
    A("激活"),
    B("冻结");
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
