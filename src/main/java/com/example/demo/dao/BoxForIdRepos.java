package com.example.demo.dao;

import com.example.demo.entity.BoxForId;
import com.example.demo.entity.BoxInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoxForIdRepos extends JpaRepository<BoxForId,String> {
    @Query(nativeQuery = true,value = "select box_id from instruction_info where experiment_id = ?1 group by box_id")
    List<BoxForId> getBoxId(String expId);
}
