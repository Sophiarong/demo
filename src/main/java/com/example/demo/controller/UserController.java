package com.example.demo.controller;

import com.example.demo.entity.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;
    private Resp resp;
    private User user;

    @RequestMapping(value={"/login"}, method=RequestMethod.POST)
    public Resp login(String userName,String password){
        this.user =  userMapper.login(userName,password);
        if(user == null){
            return new Resp(500, "it doesn't success", user);
        }else if(!(user.getPassword()).equals(password)){
            return new Resp(505, "it doesn't success", user);
        }else{
            return new Resp(200, "it success", user);
        }
    }
}