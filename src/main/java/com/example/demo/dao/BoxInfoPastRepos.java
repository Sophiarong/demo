package com.example.demo.dao;

import com.example.demo.entity.BoxInfoPast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BoxInfoPastRepos extends JpaRepository<BoxInfoPast,String> {
    @Query(nativeQuery = true,value = "select * from record_info where box_id = ?1 and experiment_id = ?2 order by sample_time desc limit 1")
    List<BoxInfoPast> boxInfoPast(int a,String k);
}
