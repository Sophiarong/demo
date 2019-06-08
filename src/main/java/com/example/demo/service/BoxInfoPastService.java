package com.example.demo.service;

import com.example.demo.dao.BoxInfoPastRepos;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("BoxInfoPastService")
public class BoxInfoPastService {
    @Resource
    BoxInfoPastRepos boxInfoPastRepos;

    public List boxInfoPast(int boxId,String expId){
        return boxInfoPastRepos.boxInfoPast(boxId,expId);
    }
}
