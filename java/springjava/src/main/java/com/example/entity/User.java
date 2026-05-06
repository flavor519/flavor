package com.example.entity;

import java.io.Serializable;

// 用户实体类：对应数据库 user 表
public class User implements Serializable {

    // 主键ID
    private Integer userid;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 年龄
    private Integer age;
    // 性别
    private String gender;
    // 手机号
    private String phone;

    // 无参构造（必须有！MyBatis需要）
    public User() {
    }

    // getter & setter —— 必须写
    public Integer getId() {
        return userid;
    }

    public void setId(Integer id) {
        this.userid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}