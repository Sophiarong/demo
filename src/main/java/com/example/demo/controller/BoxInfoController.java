package com.example.demo.controller;


import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoxInfoController {
    @Autowired
    private BoxInfoService boxInfoService;
    @Autowired
    private GrowDetailService growDetailService;
    @Autowired
    private InstructionService instructionService;
    @Autowired
    private BoxInfoPastService boxInfoPastService;
    @Autowired
    private PastGrowDetailService pastGrowDetailService;

    @ResponseBody
    @RequestMapping(value = "/boxinfo")
    public List queryBoxInfo(int boxId,int expStatus,String expId) {
        List<Object> list = new ArrayList<>();
        if(expStatus == 1){
            //返回该实验的创建命令和所有中途变更命令
            List<Instruction> instructionList = instructionService.queryPastIns(expId);
            for(int i = 0;i < instructionList.size();i++){
                if (instructionList.get(i).getBoxId() == boxId && instructionList.get(i).getInsStatus()!= 3){
                    list.add(instructionList.get(i));
                }
            }
            //得到箱子的实时环境
            List<BoxInfo> boxInfoList = boxInfoService.queryBoxInfo(boxId);
            //得到箱子中的生长细节，就是折线图需要用到的数据，这个地方我在数据库里写了一个存储过程叫做proc，参数是boxid
            List<GrowDetail> growList = growDetailService.queryGrowDetail(boxId);
            //把它们拼起来
            list.add(boxInfoList);
            list.add(growList);
            System.out.println(growList);
            return list;
        }else if(expStatus == 2){
            //这里返回了该实验的创建命令和所有中途变更命令
            List<Instruction> instructionList = instructionService.queryPastIns(expId);
            List<BoxInfoPast> boxInfoPastList = boxInfoPastService.boxInfoPast(boxId,expId);
            for(int i = 0;i < instructionList.size();i++){
                if (instructionList.get(i).getBoxId() == boxId){
                    list.add(instructionList.get(i));
                }
            }
            list.add(boxInfoPastList);
            //这里返回了该箱子的植物生长折线图数据
            list.add(pastGrowDetailService.queryPastGrowDetail(expId,boxId));
            return list;
        }
        return null;
    }
}

