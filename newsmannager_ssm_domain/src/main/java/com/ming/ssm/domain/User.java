package com.ming.ssm.domain;
import java.io.Serializable;

/**
 *@program: newsmannager_ssm
 *@description: 用户的实体类
 *@author: ming
 *@create: 2020-07-30 12:45
 */
public class User implements Serializable {
    private String uid;
    private String username;
    private String gender;
    private int age;
    private String email;
    private String password;

    public String getId() {
        return uid;
    }

    public void setId(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
