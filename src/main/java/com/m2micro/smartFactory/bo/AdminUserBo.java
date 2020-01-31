package com.m2micro.smartFactory.bo;

import com.m2micro.smartFactory.model.Admin;

import java.io.Serializable;
/*
* 编辑管理员Bo
* */
public class AdminUserBo implements Serializable {
    private Integer id;
    private String name;//姓名
    private String number;//账号
    private String password;//密码
    private String phone;//联系电话
    private String email;//邮箱
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
