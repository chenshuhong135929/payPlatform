package com.m2micro.smartFactory.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="file")
public class File implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String fileName;
    private String filePath;
    private Integer related;
    private String type;

    public Integer getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getRelated() {
        return related;
    }

    public String getType() {
        return type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setRelated(Integer related) {
        this.related = related;
    }

    public void setType(String type) {
        this.type = type;
    }
}
