package com.example.demo.service;

import com.example.demo.dao.BoxInfoRepos;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("BoxInfoService")
public class BoxInfoService {
    @Resource
    BoxInfoRepos boxInfoRepos;

    public List queryBoxInfo(int boxId){
        return boxInfoRepos.findBoxInfoByBoxIdEquals(boxId);
    }
}
