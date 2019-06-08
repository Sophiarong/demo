package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
    实验参数二次修改的时候
 */
@Controller
public class InsSecController {
    @Autowired
    private InstructionService instructionService;
    @Autowired
    private ExpForIdService expForIdService;
    @Autowired
    private ExpService expService;
    @Autowired
    private BoxService boxService;
    @Autowired
    private PlantService plantService;
    @Autowired
    private NutrientService nutrientService;
    @Autowired
    private UserForIdService userForIdService;

    @ResponseBody
    @RequestMapping(value = "/ins",params = {"expId","userId"})
    public JSONArray getSavedIns(String expId,int userId){
        JSONArray jsonArray = new JSONArray();
        List<Instruction> tmp = instructionService.queryInstructionSec(expId);
        if(userId == userForIdService.getUserId(tmp.get(0).getInsId())){
            //本实验的各种信息 包括目的、描述、状态等等
            jsonArray.add(expService.queryExpSelected(0,expId));
            //我当时保存下来的命令的信息
            jsonArray.add(instructionService.queryInstructionSec(expId));
            //目前所有箱子的可选情况
            jsonArray.add(boxService.queryBoxStatusAll());
            //可选植物
            jsonArray.add(plantService.plant());
            //可选营养液
            jsonArray.add(nutrientService.nutrient());
            return jsonArray;
        }else{
            jsonArray.add("rejection");
            return jsonArray;
        }
    }

    //用户可以按保存(0)、开始(1)、删除（3）
    //不知道为什么老是返回404，我明明设置了JSONArray了
    //如果Id错会返回500
    @RequestMapping(value = "/ins",params = "userId")
    public JSONArray queryInsSec(@RequestBody GetSecIns data,int userId) {
        JSONArray a = new JSONArray();
        List<Instruction> tmpins = instructionService.queryInstructionSec(data.getExperimentId());
        if(userId == userForIdService.getUserId(tmpins.get(0).getInsId())){
            if ((data.getInsStatus() == 0 )|| (data.getInsStatus() == 1)) {
                //如果是保存或者开始，就把原来的东西废弃或释放
                // 命令表中的instruction_status设置为3，实验表中的experiment_statsu也设为3，箱子表中的box_status设为空闲3
                instructionService.queryChangeInsStatus(data.getExperimentId());
                expService.queryExpStatus(data.getExperimentId());
                for(int u = 0; u < data.getBoxes().size();u++){
                    boxService.queryChangeBoxStatus(data.getBoxes().get(u).getBoxId());
                }
                // 然后重新用今天生成的实验ID加载命令存入表中
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
                //命令队列
                List<Ins> ins = new ArrayList<>();
                Ins tmp = new Ins();
                tmp.setExperimentName(data.getExperimentName());
                tmp.setExperimentId(s);
                tmp.setInsCode(6);
                tmp.setInsStatus(data.getInsStatus());
                tmp.setImgTimeout(data.getImgTimeout());
                tmp.setSampleTimeout(data.getSampleTimeout());
                tmp.setPlantId(data.getPlantId());
                tmp.setExpAddress(data.getExpAddress());
                tmp.setExpDescription(data.getExpDescription());
                tmp.setExpPurpose(data.getExpPurpose());
                tmp.setInstructionPersonId(data.getExperimentPersonId());
                for (int i = 0; i < data.getBoxes().size(); i++) {
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
                    expForIdService.queryInsertIns(tmp.getInsCode(), tmp.getInsStatus(), tmp.getExperimentId(), tmp.getExperimentName(), tmp.getInstructionPersonId(),
                            tmp.getBoxId(), tmp.getPlantId(), tmp.getLightId(), tmp.getLightRed(), tmp.getLightBlue(), tmp.getLightGreen(), tmp.getLightInfrared(),
                            tmp.getLightUltraviolet(), tmp.getLightWhite(), tmp.getBoxTemperature(), tmp.getBoxHumidity(), tmp.getBoxCo2(), tmp.getNutrientId(),
                            tmp.getSampleTimeout(), tmp.getImgTimeout());
                }
                expService.queryExpTable(data.getExpPurpose(),data.getExpDescription(),data.getExpAddress(),s);
                //这个地方为什么无法成功。。老返回500，令人崩溃
                a.add("save again");
                return a;
            } else{
                //如果是删除，就把instruction_status设置为3，然后改实验表，改箱子表
                instructionService.queryChangeInsStatus(data.getExperimentId());
                expService.queryExpStatus(data.getExperimentId());
                for(int q = 0; q < data.getBoxes().size();q++){
                    boxService.queryChangeBoxStatus(data.getBoxes().get(q).getBoxId());
                }
                a.add("delete");
                return a;
            }
        }else{
            a.add("rejection");
            return a;
        }
    }
}
