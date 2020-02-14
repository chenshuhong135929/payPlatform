package com.m2micro.smartFactory.vo;

import java.io.Serializable;

public class FileVo implements Serializable {
    private Integer id;
    private String fileName;
    private String filePath;
    private Integer related;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getRelated() {
        return related;
    }

    public void setRelated(Integer related) {
        this.related = related;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
