package com.example.demo.dao;

import com.example.demo.entity.ExpForId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ExpForIdRepos extends JpaRepository<ExpForId,String> {
    @Query(nativeQuery = true,value = " select experiment_id from experiment_info where experiment_id like %?1%")
    List<ExpForId> expCal(String s);
    @Query(nativeQuery = true,value = "select functionlight()")
    int findLightId();
    // 在命令表插入新的实验
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "INSERT INTO plantsystem.instruction_info(instruction_code, instruction_status,\n" +
            " experiment_id,experiment_name, instruction_person_id, box_id, plant_id, light_id, light_red, light_blue, light_green,\n" +
            " light_infrared, light_ultraviolet, light_white, box_temperature, box_humidity, box_co2, nutrient_id, sample_timeout, img_timeout) \n" +
            " VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18, ?19, ?20)")
    void insertIns(int instruction_code,int instruction_status,String experiment_id,String experiment_name,int instruction_person_id,
                   int box_id,int plant_id,int light_id,int light_red,int light_blue,int light_green,int light_infrared,
                   int light_ultraviolet,int light_white,int box_temperature, int box_humidity,int box_co2,int nutrient_id,
                   int sample_timeout,int img_timeout);
}
