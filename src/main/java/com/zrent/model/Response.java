package com.zrent.model;

/**
 * @author Zrent
 */
public class Response {
    private Integer code;
    private String status;
    private Object data;


    public Response() {
    }

    public Response(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public Response(Integer code, String status, Object data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
