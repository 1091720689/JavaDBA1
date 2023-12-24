package com.atguigu.bean;

import java.util.Arrays;

/**
 * @Author chenxin
 * @date 2022/8/22
 * @Version 1.0
 */
public class User {
    private String username;
    private String password;
    private Integer gender;
    private String address;
    private String[] hobby;

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public User() {
    }

    public User(String username, String password, Integer gender, String address, String[] hobby) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }
}
