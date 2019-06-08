package com.example.demo.dao;
import com.example.demo.entity.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface InstructionRepos extends JpaRepository<Instruction,String> {
    @Query(nativeQuery = true ,value = " select instruction_id,instruction_status,experiment_id,experiment_name,instruction_send_time,user_name,box_id,plant_id,light_red,light_blue,light_green,light_infrared,light_ultraviolet,light_white,box_temperature,box_Humidity,box_co2,nutrient_id,sample_timeout,img_timeout\n" +
            " from instruction_info inner join user_info on instruction_person_id = user_id\n" +
            " where instruction_status = 0 and experiment_id = ?1")
    List<Instruction> insSaved(String expId);

    //更新Instruction表，把instruction_status设为2
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = " update instruction_info set instruction_status = 3 where experiment_id =?1")
    void changeInsStatus(String expId);

    @Query(nativeQuery = true,value = " select instruction_id,instruction_status,experiment_id,experiment_name,instruction_send_time,user_name,box_id,plant_id,light_red,light_blue,light_green,\n" +
            " light_infrared,light_ultraviolet,light_white,box_temperature,box_Humidity,box_co2,nutrient_id,sample_timeout,img_timeout from instruction_info \n" +
            " inner join user_info on instruction_person_id = user_id where (experiment_id = ?1 )and (box_id = ?2) and (instruction_status = 1 or 2) \n" +
            " order by instruction_send_time desc limit 1")
    List<Instruction> lastInstruction(String expId,int boxId);

    @Query(nativeQuery = true ,value = " select instruction_id,instruction_status,experiment_id,experiment_name,instruction_send_time,user_name,box_id,plant_id,light_red,light_blue,light_green,light_infrared,light_ultraviolet,light_white,box_temperature,box_Humidity,box_co2,nutrient_id,sample_timeout,img_timeout\n" +
            " from instruction_info inner join user_info on instruction_person_id = user_id\n" +
            " where experiment_id = ?1")
    List<Instruction> insPast(String expId);
}
