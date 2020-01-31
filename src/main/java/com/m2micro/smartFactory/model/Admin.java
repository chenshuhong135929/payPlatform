package com.m2micro.smartFactory.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="admin")
public class Admin  implements Serializable {
    private Integer id;
    private String number;
    private String password;
    private String disableStatus;//启用禁用状态

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name="disable_status")
    public String getDisableStatus() {
        return disableStatus;
    }

    public void setDisableStatus(String disableStatus) {
        this.disableStatus = disableStatus;
    }

    public Admin() {
    }


}
