package com.example.demo.service;

import com.example.demo.dao.ExpForIdRepos;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ExpForIdService")
public class ExpForIdService {
    @Resource
    private ExpForIdRepos expForIdRepos;

    public List queryExpForId(String s){return expForIdRepos.expCal(s);}
    public int queryLightForId(){
        return expForIdRepos.findLightId();}
    public void queryInsertIns(int instruction_code,int instruction_status,String experiment_id,String experiment_name,int instruction_person_id,
                               int box_id,int plant_id,int light_id,int light_red,int light_blue,int light_green,int light_infrared,
                               int light_ultraviolet,int light_white,int box_temperature, int box_humidity,int box_co2,int nutrient_id,
                               int sample_timeout,int img_timeout){
        expForIdRepos.insertIns(instruction_code,instruction_status,experiment_id,experiment_name,instruction_person_id,
                box_id,plant_id,light_id,light_red,light_blue,light_green,light_infrared,light_ultraviolet,light_white,box_temperature,
                box_humidity,box_co2, nutrient_id,sample_timeout,img_timeout);
    }
}
