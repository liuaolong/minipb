package com.zrent.model;

/**
 * @author Zrent
 */
public class Candition {

    private String queryName;
    private Integer queryMinPrice;
    private Integer queryMaxPrice;

    public Candition() {
    }

    public Candition(String queryName, Integer queryMinPrice, Integer queryMaxPrice) {
        this.queryName = queryName;
        this.queryMinPrice = queryMinPrice;
        this.queryMaxPrice = queryMaxPrice;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public Integer getQueryMinPrice() {
        return queryMinPrice;
    }

    public void setQueryMinPrice(Integer queryMinPrice) {
        this.queryMinPrice = queryMinPrice;
    }

    public Integer getQueryMaxPrice() {
        return queryMaxPrice;
    }

    public void setQueryMaxPrice(Integer queryMaxPrice) {
        this.queryMaxPrice = queryMaxPrice;
    }
}
