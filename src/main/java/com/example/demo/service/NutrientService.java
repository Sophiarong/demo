package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.NutrientRepos;
import com.example.demo.dao.PlantRepos;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("NutrientService")
public class NutrientService {
    @Resource
    NutrientRepos nutrientRepos;
    public JSONObject nutrient(){
        JSONObject json = new JSONObject();
        json.put("nutrient",nutrientRepos.findAll());
        return json;
    }
}
