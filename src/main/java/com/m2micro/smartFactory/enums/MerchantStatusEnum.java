package com.m2micro.smartFactory.enums;

public enum MerchantStatusEnum {
    A("营业"),
    B("休息");
    private String name;
    MerchantStatusEnum(String name){
        this.name = name;
    }
    MerchantStatusEnum(){

    }

    public void setName(String name) {
        this.name = name;
    }
}
