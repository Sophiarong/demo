package com.example.demo.controller;

import com.example.demo.dao.GrowDetailRepos;
import com.example.demo.entity.GrowDetail;
import com.example.demo.service.GrowDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GrowController {
    @Autowired
    private GrowDetailService growDetailService;

    @ResponseBody
    @RequestMapping(value = {"/growdetail"})
    public List queryGrowAll(int boxId) {
        List<GrowDetail> growList = growDetailService.queryGrowDetail(boxId);
        return growList;
    }
}
