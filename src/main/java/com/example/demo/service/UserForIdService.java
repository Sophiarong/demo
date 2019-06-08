package com.example.demo.service;

import com.example.demo.dao.UserForIdRepos;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserForIdService")
public class UserForIdService {
    @Resource
    UserForIdRepos userForIdRepos;
    public int getUserId(int a){
        return userForIdRepos.userForId(a).get(0);
    }
}
