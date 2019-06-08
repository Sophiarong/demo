package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/*
    实验参数初次保存的时候
 */
@Controller
public class InsFirController {
    @Autowired
    private ExpForIdService expForIdService;
    @Autowired
    private BoxService boxService;
    @Autowired
    private ExpService expService;
    @Autowired
    private PlantService plantService;
    @Autowired
    private NutrientService nutrientService;
    @Autowired
    private InstructionService instructionService;
    @ResponseBody
    @RequestMapping(value = "/ins",method= RequestMethod.GET)
    public JSONArray queryInsBox(){
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(boxService.queryBoxStatusAll());
        jsonArray.add(plantService.plant());
        jsonArray.add(nutrientService.nutrient());
        return jsonArray;
    }
    //用户可以按保存（0），开始实验（1）
    //初次创建实验老是返回500，我明明设置了JSONArray了
    @RequestMapping(value = "/ins",method= RequestMethod.POST)
    public JSONArray queryInsFir(@RequestBody GetIns data) {
        JSONArray a = new JSONArray();

        //获得当前日期，数据库模糊匹配
        int y, m, d;
        String s;
        Calendar cal = Calendar.getInstance();
        y = cal.get(Calendar.YEAR);
        m = cal.get(Calendar.MONTH) + 1;
        d = cal.get(Calendar.DATE);
        if (m < 10) {
            if (d < 10) {
                s = String.valueOf(y) + '0' + String.valueOf(m) + '0' + String.valueOf(d);
            } else {
                s = String.valueOf(y) + '0' + String.valueOf(m) + String.valueOf(d);
            }
        } else {
            s = String.valueOf(y) + String.valueOf(m) + String.valueOf(d);
        }
        //设置实验ID，格式yyyymmdd-001~yyyymmdd-999
        List<ExpForId> expInsList = expForIdService.queryExpForId(s);
        String[] tmp1 = new String[expInsList.size()];
        int tmp2 = 0;
        for (int i = 0; i < expInsList.size(); i++) {
            tmp1[i] = expInsList.get(i).getExpId().split("-")[1];
            if (Integer.parseInt(tmp1[i]) > tmp2)
                tmp2 = Integer.parseInt(tmp1[i]);
        }
        tmp2++;
        if (tmp2 < 999) {
            if (tmp2 < 100) {
                if (tmp2 < 10) {
                    s = s + "-" + "00" + String.valueOf(tmp2);
                } else {
                    s = s + "-" + "0" + String.valueOf(tmp2);
                }
            } else {
                s = s + "-" + String.valueOf(tmp2);
            }
        }
        System.out.println(s);
        //获得光参数表的最大ID
        int lightid = expForIdService.queryLightForId() + 1;
        //存在instruction_info中的命令
        Ins tmp = new Ins();
        tmp.setExperimentName(data.getExperimentName());
        tmp.setExperimentId(s);
        tmp.setInsCode(6);
        tmp.setPlantId(data.getPlantId());
        tmp.setSampleTimeout(data.getSampleTimeout());
        tmp.setImgTimeout(data.getImgTimeout());
        tmp.setInsStatus(data.getInsStatus());
        tmp.setInstructionPersonId(data.getExperimentPersonId());
        for(int i = 0; i< data.getBoxes().size();i++){
            tmp.setBoxId(data.getBoxes().get(i).getBoxId());
            tmp.setLightId(lightid);
            tmp.setLightRed(data.getBoxes().get(i).getLightRed());
            tmp.setLightBlue(data.getBoxes().get(i).getLightBlue());
            tmp.setLightGreen(data.getBoxes().get(i).getLightGreen());
            tmp.setLightInfrared(data.getBoxes().get(i).getLightInfrared());
            tmp.setLightUltraviolet(data.getBoxes().get(i).getLightUltraviolet());
            tmp.setBoxTemperature(data.getBoxes().get(i).getBoxTemperature());
            tmp.setBoxHumidity(data.getBoxes().get(i).getBoxHumidity());
            tmp.setBoxCo2(data.getBoxes().get(i).getBoxCo2());
            tmp.setNutrientId(data.getBoxes().get(i).getNutrientId());
            lightid++;

            expForIdService.queryInsertIns(tmp.getInsCode(),tmp.getInsStatus(),tmp.getExperimentId(),tmp.getExperimentName(),tmp.getInstructionPersonId(),
                    tmp.getBoxId(),tmp.getPlantId(),tmp.getLightId(),tmp.getLightRed(),tmp.getLightBlue(),tmp.getLightGreen(),tmp.getLightInfrared(),
                    tmp.getLightUltraviolet(),tmp.getLightWhite(),tmp.getBoxTemperature(),tmp.getBoxHumidity(),tmp.getBoxCo2(),tmp.getNutrientId(),
                    tmp.getSampleTimeout(),tmp.getImgTimeout());
        }
            //存在experiment_info中的部分
        expService.queryExpTable(data.getExpPurpose(),data.getExpDescription(),data.getExpAddress(),s);
        a.add("success");
        return a;
    }
}
