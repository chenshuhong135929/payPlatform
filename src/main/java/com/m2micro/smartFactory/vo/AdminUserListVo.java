package com.m2micro.smartFactory.vo;

import java.io.Serializable;
/*
管理员用户列表vo
 */
public class AdminUserListVo   implements Serializable {
    private Integer id;
    private String name;//姓名
    private String number;//编号
    private String remark;//备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
