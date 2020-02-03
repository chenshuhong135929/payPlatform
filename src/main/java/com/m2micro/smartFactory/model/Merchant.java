package com.m2micro.smartFactory.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*
商户模型
 */

@Entity
@Table(name="merchant")
public class Merchant implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;//s商户名称
    private String legalPerson;//法人
    private String idLastNumber;//身份证后四位
    private String linkPhone;//联系电话
    private String linkEmali;//类型邮箱
    private String registeredAddress;//注册地址
    private String openAddress;//营业地址
    private String mailbox;//邮箱
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date  registeredDate;//营业时间
    private String industry;//行业
    private String dataDictionary;//数据字典
    private String explainContent;//解释内容
    private String doBusiness;//经营业务

    public Merchant() {
    }

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

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getIdLastNumber() {
        return idLastNumber;
    }

    public void setIdLastNumber(String idLastNumber) {
        this.idLastNumber = idLastNumber;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkEmali() {
        return linkEmali;
    }

    public void setLinkEmali(String linkEmali) {
        this.linkEmali = linkEmali;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getOpenAddress() {
        return openAddress;
    }

    public void setOpenAddress(String openAddress) {
        this.openAddress = openAddress;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getDataDictionary() {
        return dataDictionary;
    }

    public void setDataDictionary(String dataDictionary) {
        this.dataDictionary = dataDictionary;
    }

    public String getExplainContent() {
        return explainContent;
    }

    public void setExplainContent(String explainContent) {
        this.explainContent = explainContent;
    }

    public String getDoBusiness() {
        return doBusiness;
    }

    public void setDoBusiness(String doBusiness) {
        this.doBusiness = doBusiness;
    }
}
