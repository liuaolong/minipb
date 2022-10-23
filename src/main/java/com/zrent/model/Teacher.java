package com.zrent.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @description:教师类
 * @author:Zrent
 * @date : 2022/10/18
 */
public class Teacher {
    private Integer id;
    private String account;
    private String name;
    private String phone;
    private String mail;
    private Integer level;
    private String photo;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    public Teacher() {
    }

    public Teacher(Integer id, String account, String name, String phone, String mail, Integer level, String photo, Date addTime) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.level = level;
        this.photo = photo;
        this.addTime = addTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
