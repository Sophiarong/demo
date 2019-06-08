package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.BoxRepos;
import com.example.demo.entity.Box;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("BoxService")
public class BoxService {
    @Resource
    private BoxRepos boxRepos;

    public List queryBoxAll(){
        return boxRepos.findAll();
    }
    public List queryboxSelected(String expId){return boxRepos.boxSelected(expId);}
    public JSONObject queryBoxStatusAll(){
        JSONObject json = new JSONObject();
        List<Box> box = boxRepos.findAll();
        List<Integer> tmp1 = new ArrayList<>();
        List<Integer> tmp2 = new ArrayList<>();
        List<Integer> tmp3 = new ArrayList<>();
        List<Integer> tmp4 = new ArrayList<>();
        //String tmpS,tmpS1 = "无法进行实验的箱子：",tmpS2 = "被保存预定的箱子：",tmpS3 = "正在运行实验的箱子：",tmpS4="空闲的可选择的箱子：";
        for(int i = 0; i < box.size(); i++){
            if(box.get(i).getBoxStatus() == 0){
                tmp1.add(box.get(i).getBoxId());
                //tmpS1 = tmpS1 + String.valueOf(box.get(i).getBoxId()) + ",";
            }else if(box.get(i).getBoxStatus() == 1){
                tmp2.add(box.get(i).getBoxId());
                //tmpS2 = tmpS2 + String.valueOf(box.get(i).getBoxId()) + ",";
            }else if(box.get(i).getBoxStatus() == 2){
                tmp3.add(box.get(i).getBoxId());
                //tmpS3 = tmpS3 + String.valueOf(box.get(i).getBoxId()) + ",";
            }else if(box.get(i).getBoxStatus() == 3){
                tmp4.add(box.get(i).getBoxId());
                //tmpS4 = tmpS4 + String.valueOf(box.get(i).getBoxId()) + ",";
            }
        }
        json.put("无法进行实验的箱子：",tmp1);
        json.put("被保存预定的箱子：",tmp2);
        json.put("正在运行实验的箱子：",tmp3);
        json.put("空闲的可选择的箱子：",tmp4);
        //tmpS = tmpS1 + tmpS2 + tmpS3 + tmpS4;
        return json;
    }
    public void queryChangeBoxStatus(int boxId){
        boxRepos.changeBoxStatus(boxId);
    }

    public void queryChangeBoxExp(int boxId){
        boxRepos.changeBoxExp(boxId);
    }
}
