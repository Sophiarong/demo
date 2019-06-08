package com.example.demo.service;

import com.example.demo.dao.PastGrowDetailRepos;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PastGrowDetailService")
public class PastGrowDetailService {
    @Resource
    PastGrowDetailRepos pastGrowDetailRepos;
    public List queryPastGrowDetail(String expId, int boxId){
        return pastGrowDetailRepos.getPastGrowDetail(expId,boxId);
    }

}
