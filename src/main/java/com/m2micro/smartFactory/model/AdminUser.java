package com.m2micro.smartFactory.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="admin_user")
public class AdminUser  implements Serializable {
    private Integer id;
    private String name;//姓名
    private String number;//账号
    private String password;//密码
    private String phone;//联系电话
    private String email;//邮箱
    private String remark;//备注
    private Date createDate;//创建时间
    private String disableStatus;//启用禁用状态
    private String status;//状态 Datastatus
    private Admin admin;//创建人 防止以后有多个超级管理员
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name="phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Column(name="status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Column(name="disable_status")
    public String getDisableStatus() {
        return disableStatus;
    }

    public void setDisableStatus(String disableStatus) {
        this.disableStatus = disableStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
