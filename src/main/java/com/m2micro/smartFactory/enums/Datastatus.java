package com.m2micro.smartFactory.enums;

import javax.print.DocFlavor;

public enum Datastatus {
    A("使用"),
    B("删除");
    private String name;
     Datastatus(String name){
        this.name = name;
    }
    Datastatus(){

    }

    public void setName(String name) {
        this.name = name;
    }
}
