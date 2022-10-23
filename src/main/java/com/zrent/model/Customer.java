package com.zrent.model;

import javax.xml.crypto.Data;

/**
 * @author Zrent
 */
public class Customer {
    private Integer id;
    private String openid;
    private String sessionKey;
    private String nickname;
    private String avatarUrl;
    private Data addTime;
    private String account;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Data getAddTime() {
        return addTime;
    }

    public void setAddTime(Data addTime) {
        this.addTime = addTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer(String openid, String sessionKey, String nickname, String avatarUrl) {
        this.openid = openid;
        this.sessionKey = sessionKey;
        this.nickname = nickname;
        this.avatarUrl = avatarUrl;
    }
}
