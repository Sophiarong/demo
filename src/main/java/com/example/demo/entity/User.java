package com.example.demo.entity;

import java.util.List;

import lombok.Data;

@Data
public class User {

    public static enum Role {
        Admin
    }

    private String id;
    private String username;
    private String password;
    private String telephone;
    private int authority;
    private List<Role> roles;

}

