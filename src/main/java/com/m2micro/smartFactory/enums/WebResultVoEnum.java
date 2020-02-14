package com.m2micro.smartFactory.enums;

public enum  WebResultVoEnum {
    SUCCESS(200,"请求成功"),
    ERROR(500,"服务器异常"),
    PARAMETERERROR(300,"参数异常"),
    NOAUTHORITY(400,"参数异常"),
    ILLEGALOPERATION(600,"非法操作");
    private Integer code;
    private String message;

    WebResultVoEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    WebResultVoEnum() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
