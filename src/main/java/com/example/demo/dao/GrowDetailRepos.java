package com.example.demo.dao;

import com.example.demo.entity.GrowDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GrowDetailRepos extends JpaRepository<GrowDetail,String>  {
    @Query(nativeQuery = true, value = "call proc(?1)")
    List<GrowDetail> getGrowDetail1(int boxId);
//    这种方式也可以
//    @Query(nativeQuery = true, value = "select * from tmp2")
//    List<GrowDetail> getGrowDetail2();
//    @Transactional
//    @Modifying
//    @Query(nativeQuery = true, value = "drop table tmp2")
//    void getGrowDetail3();
}

