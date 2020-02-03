package com.m2micro.smartFactory.model;

import org.springframework.scheduling.support.SimpleTriggerContext;

import java.io.Serializable;
/*
商户模型
 */
public class Merchant implements Serializable {
    private Integer id;
    private String name;//s商户名称
    private String legalPerson;//法人
    private String idLastNumber;//身份证后四位
    private String linkPhone;//联系电话
    private String linkEmali;//类型邮箱
    private String registeredAddress;//注册地址
    private String openAddress;//营业地址
    private String mailbox;//邮箱

}
