package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Box;

import com.example.demo.entity.Exp;
import com.example.demo.entity.IndexModel;
import com.example.demo.service.BoxService;

import com.example.demo.service.ExpService;
import com.example.demo.service.GrowDetailService;
import com.example.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private BoxService boxService;
    @Autowired
    private IndexService indexService;
    @Autowired
    private GrowDetailService growDetailService;
    @Autowired
    private ExpService expService;

    @ResponseBody
    @RequestMapping(value = {"/index","/"})
    public List queryBoxAll() {
        List<Box> boxListAll = boxService.queryBoxAll();
        List<IndexModel> indexListAll = indexService.queryIndexAll();
        List<Object> list = new ArrayList<>();
        for(int i = 0; i < boxListAll.size(); i++){
            if(i < indexListAll.size()){
                if(indexListAll.get(i).getBoxId() == boxListAll.get(i).getBoxId()){
                    list.add(indexListAll.get(i));
                }
            }else{
                list.add(boxListAll.get(i));
            }
        }
        return list;
    }
//        @ResponseBody
//        @RequestMapping(value = {"/index","/"})
//        public JSONArray queryBoxAll() {
//            JSONArray jsonArray = new JSONArray();
//            JSONObject json = new JSONObject();
//            List<Box> boxListAll = boxService.queryBoxAll();
//            List<IndexModel> indexListAll = indexService.queryIndexAll();
//            for(int i = 0; i < boxListAll.size(); i++){
//                System.out.println(boxListAll.get(i) + "\n");
//                json.put("box",boxListAll.get(i));
//                for(int j = 0; j < indexListAll.size(); j++){
//                    if(indexListAll.get(j).getBoxId() == boxListAll.get(i).getBoxId())
//                        System.out.println(indexListAll.get(j) + "\n");
//                        json.put("info",indexListAll.get(j));
//                }
//                jsonArray.add(json);
//                System.out.println(json);
//                json.clear();
//            }
//            return jsonArray;
//        }

    @ResponseBody
    @RequestMapping(value = "/home")
    public List queryExpAll() {
        List<Object> listhome = new ArrayList<>();
        //显示在右边的实验概要
        List<Exp> expRunning = expService.queryExpRunning();
        listhome.add(expRunning);
        //获取正在进行实验的实验箱号，并反馈生长状况
        List<IndexModel> expListAll = indexService.queryIndexAll();
        int box[] = new int[expListAll.size()];
        for(int i = 0;i < expListAll.size();i++){
            listhome.add(growDetailService.queryGrowDetail(expListAll.get(i).boxId));
        }
        return listhome;
    }
}