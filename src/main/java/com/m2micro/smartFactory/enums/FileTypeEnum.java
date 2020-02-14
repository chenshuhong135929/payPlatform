package com.m2micro.smartFactory.enums;

public enum  FileTypeEnum {
    A("门户照"),
    B("营业执照");
    private String name;
    FileTypeEnum(String name){
        this.name = name;
    }
    FileTypeEnum(){

    }

    public void setName(String name) {
        this.name = name;
    }
}
