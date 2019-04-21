package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private String id;
    private String userName;
    private String password;
    private String telephone;
    private int authority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String toString(){
        return "user:" + userName + "/password" + password + "telephone" + telephone;
    }




}

