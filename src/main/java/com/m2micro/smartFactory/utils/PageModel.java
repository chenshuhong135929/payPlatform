package com.m2micro.smartFactory.utils;

import java.util.List;

public class PageModel<T> {
    private Integer pageSize;
    private Integer pageNo;
    private List<T> data;
    private Long total;

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

    public  List<T> getData() {
        return data;
    }

    public void setData( List<T> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public PageModel(Integer pageSize, Integer pageNo,  List<T> data, Long total) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.data = data;
        this.total = total;
    }

    public PageModel() {
    }
}
