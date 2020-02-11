package com.m2micro.smartFactory.bo;

import java.io.Serializable;

public class PageBo implements Serializable {
    private int pageSize = 10;
    private int pageNo = 1;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public PageBo(Integer pageSize, Integer pageNo) {
        if(pageSize != null){
            this.pageSize = pageSize;
        }
        if(pageNo != null){
            this.pageNo = pageNo;
        }

    }



}
// docker-compose  down
// docker images
// docker rmi  IMAGE ID
// docker-compose  up  -d