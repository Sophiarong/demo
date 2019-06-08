package com.example.demo.dao;

import com.example.demo.entity.Exp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ExpRepos extends JpaRepository<Exp,String> {
    //用在Home那一页的
    @Query(nativeQuery = true,value = "select experiment_id,plant_id,experiment_name,start_time,end_time,experiment_purpose,experiment_description,experiment_address,user_name,experiment_record,experiment_status,experiment_result from\n" +
            "(experiment_info inner join user_info on user_id = experiment_person_id) \n" +
            "where experiment_status = 1")
    List<Exp> expRunning();

    //查看实验详情
    @Query(nativeQuery = true,value = " select experiment_id,plant_id,experiment_name,start_time,end_time,experiment_purpose,experiment_description,experiment_address,user_name,experiment_record,experiment_status,experiment_result from \n" +
            " experiment_info inner join user_info on user_id = experiment_person_id\n" +
            " where experiment_status = ?1 AND experiment_id = ?2")
    List<Exp> expInfo(int a, String expId);

    //把实验状态更新为废弃
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = " update experiment_info set experiment_status = 3 where experiment_id =?1")
    void changeExpStatus(String expId);

    //把实验状态更新为停止
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = " update experiment_info set experiment_status = 2 where experiment_id =?1")
    void changeExpStop(String expId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value ="update experiment_info set experiment_purpose = ?1,experiment_description = ?2, experiment_address = ?3 where experiment_id =?4")
    void changeExpTable(String purpose,String description,String address,String expId);
}
