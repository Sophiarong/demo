package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.BoxService;
import com.example.demo.service.ExpForIdService;
import com.example.demo.service.ExpService;
import com.example.demo.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExpRunningController {
    @Autowired
    private ExpService expService;
    @Autowired
    private BoxService boxService;
    @Autowired
    private InstructionService instructionService;
    @Autowired
    private ExpForIdService expForIdService;
    @ResponseBody
    @RequestMapping(value = "/exprunning",method= RequestMethod.GET)
    public List queryExpRunning(String expId){
        List<Object> list = new ArrayList<>();
        List<Box> boxListAll = boxService.queryBoxAll();
        List<Exp> expList = expService.queryExpSelected(1,expId);
        list.add(expList);
        for(int j = 0; j < boxListAll.size();j++){
            if(boxListAll.get(j).getExpId() != null){
                if(boxListAll.get(j).getExpId().equals(expId)){
                    list.add(instructionService.queryLastIns(expId,boxListAll.get(j).getBoxId()));
                }
            }
        }
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/exprunning",method= RequestMethod.POST)
    public String expManage(@RequestBody GetSecIns data){
        if(data.getInsStatus() == 5){
            //停止实验，就更改实验表，把实验的标志位设置为2，把箱子释放变成3，箱子的expId恢复为空
            expService.queryExpStop(data.getExperimentId());
            for(int w = 0; w < data.getBoxes().size();w++){
                boxService.queryChangeBoxStatus(data.getBoxes().get(w).getBoxId());
                boxService.queryChangeBoxExp(data.getBoxes().get(w).getBoxId());
            }
            return "stop";
        }else if(data.getInsStatus() == 4){
            return "do nothing";
        }else{
            //获得光参数表的最大ID
            int lightid = expForIdService.queryLightForId() + 1;
            Ins tmp = new Ins();
            tmp.setExperimentId(data.getExperimentId());
            tmp.setExperimentName(data.getExperimentName());
            tmp.setSampleTimeout(data.getSampleTimeout());
            tmp.setImgTimeout(data.getImgTimeout());
            tmp.setPlantId(data.getPlantId());
            tmp.setInsCode(6);
            tmp.setInsStatus(2);//2是中途改变实验环境的标志位
            tmp.setInstructionPersonId(data.getExperimentPersonId());
            for (int i = 0; i < data.getBoxes().size(); i++) {
                tmp.setBoxId(data.getBoxes().get(i).getBoxId());
                //tmp.setPlantId(data.getBoxes().get(i).getPlantId());
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
                expForIdService.queryInsertIns(tmp.getInsCode(), tmp.getInsStatus(), tmp.getExperimentId(), tmp.getExperimentName(), tmp.getInstructionPersonId(),
                        tmp.getBoxId(), tmp.getPlantId(), tmp.getLightId(), tmp.getLightRed(), tmp.getLightBlue(), tmp.getLightGreen(), tmp.getLightInfrared(),
                        tmp.getLightUltraviolet(), tmp.getLightWhite(), tmp.getBoxTemperature(), tmp.getBoxHumidity(), tmp.getBoxCo2(), tmp.getNutrientId(),
                        tmp.getSampleTimeout(), tmp.getImgTimeout());
            }
            return "change";
        }
    }
}
