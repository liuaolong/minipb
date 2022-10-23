package com.zrent.model;

import java.util.List;

/**
 * @author Zrent
 */
public class Pages<T> {
    /**
     * 每页显示条数
     */
    private Integer pageSize;
    /**
     * 共多少页
     */
    private Integer totalPage;
    /**
     * 共多少条数据
     */
    private Integer totalRecord;
    /**
     * 当前页
     */
    private Integer pageIndex;


    /**
     * 数据
     */
    private List<T> data;



    public Pages() {
    }

    public Pages(Integer pageSize, Integer totalPage, Integer totalRecord, Integer pageIndex, List<T> data) {
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalRecord = totalRecord;
        this.pageIndex = pageIndex;
        this.data = data;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}