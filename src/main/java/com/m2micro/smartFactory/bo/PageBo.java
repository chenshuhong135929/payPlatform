package com.m2micro.smartFactory.bo;

import java.io.Serializable;

public class PageBo implements Serializable {
    private Integer pageSize = 20 ;
    private Integer pageNo = 1;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public PageBo(Integer pageSize, Integer pageNo) {
        if(pageSize != null && pageNo != null){
            this.pageSize = pageSize;
            this.pageNo = pageNo;
        }

    }



}
