package com.zrent.model;

/**
 * @author Zrent
 */
public class Wxauth {
    private String session_key;
    private String openid;
    private Integer expires_in;


    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "Wxauth{" +
                "session_key='" + session_key + '\'' +
                ", openid='" + openid + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
