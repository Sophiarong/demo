package com.example.demo.dao;

import com.example.demo.entity.PastGrowDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PastGrowDetailRepos extends JpaRepository<PastGrowDetail,String> {
    @Query(nativeQuery = true,value = "call procpast(?1,?2)")
    List<PastGrowDetail>  getPastGrowDetail(String expId, int boxId);
}
