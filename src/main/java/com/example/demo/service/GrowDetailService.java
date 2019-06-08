package com.example.demo.service;

import com.example.demo.dao.GrowDetailRepos;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("GrowDetailService")
public class GrowDetailService {
    @Resource
    private GrowDetailRepos growDetailRepos;

    public List queryGrowDetail(int boxId){
//        growDetailRepos.getGrowDetail1(boxId);
//        List<GrowDetail> a = new ArrayList<>();
//        a = growDetailRepos.getGrowDetail2();
//        growDetailRepos.getGrowDetail3();
//        return a;
        return growDetailRepos.getGrowDetail1(boxId);
    }
}
