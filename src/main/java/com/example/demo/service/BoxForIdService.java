package com.example.demo.service;

import com.example.demo.dao.BoxForIdRepos;
import com.example.demo.entity.BoxForId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("BoxForIdService")
public class BoxForIdService {
    @Resource
    private BoxForIdRepos boxForIdRepos;
    public List queryBoxForId(String expId){
        return boxForIdRepos.getBoxId(expId);
    }
}
