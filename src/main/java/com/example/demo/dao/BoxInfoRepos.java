package com.example.demo.dao;

import com.example.demo.entity.BoxInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoxInfoRepos extends JpaRepository<BoxInfo,String> {
    List<BoxInfo> findBoxInfoByBoxIdEquals(int boxId);
}
