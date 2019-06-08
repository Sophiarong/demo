package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.Box;
import com.example.demo.entity.BoxForId;
import com.example.demo.entity.Exp;
import com.example.demo.entity.GrowDetail;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
/*
    接口5，expinfo,实验详情页，可以是已结束的实验（标志位为1），也可以是正在进行的实验（标志位为2）
 */
@Controller
public class ExpInfoController {
    @Autowired
    private ExpService expService;
    @Autowired
    private GrowDetailService growDetailService;
    @Autowired
    private BoxService boxService;
    @Autowired
    private BoxForIdService boxForIdService;
    @Autowired
    private PastGrowDetailService pastGrowDetailService;

    @ResponseBody
    @RequestMapping(value = "/expinfo",method= RequestMethod.GET)
    public List queryExp(int expStatus,String expId){
        List<Object> list = new ArrayList<>();
        List<Exp> expSelected = expService.queryExpSelected(expStatus,expId);
        list.add(expSelected);
        if(expStatus == 1){//正在进行实验
            List<Box> boxSelected = boxService.queryboxSelected(expId);
            int expBoxId[] = new int[boxSelected.size()];
            for(int i = 0;i < boxSelected.size();i++){
                expBoxId[i] = boxSelected.get(i).getBoxId();
                list.add(growDetailService.queryGrowDetail(expBoxId[i]));
            }
            list.add(expBoxId);
        }else if(expStatus == 2){//已经结束的实验
            List<BoxForId> boxIdList = boxForIdService.queryBoxForId(expId);
            for(int e = 0; e < boxIdList.size();e++){
                list.add("boxid = " + (e+1));
                list.add(pastGrowDetailService.queryPastGrowDetail(expId,boxIdList.get(e).getBoxId()));
            }
            list.add(boxIdList);
        }
        return list;
    }
}
