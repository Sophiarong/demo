package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.PlantRepos;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("PlantService")
public class PlantService {
    @Resource
    PlantRepos plantRepos;
    public JSONObject plant(){
        JSONObject json = new JSONObject();
        json.put("plant",plantRepos.findAll());
        return json;
    }
}
