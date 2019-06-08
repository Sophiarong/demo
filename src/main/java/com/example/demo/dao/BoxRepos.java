package com.example.demo.dao;

import com.example.demo.entity.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BoxRepos extends JpaRepository<Box,String> {
    List<Box> findAll();

    @Query(nativeQuery = true, value = " select * from box_info where experiment_id = ?1")
    List<Box> boxSelected(String expId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = " update box_info set box_status = 3 where box_id =?1")
    void changeBoxStatus(int boxId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = " update box_info set experiment_id = null where box_id =?1")
    void changeBoxExp(int boxId);

}