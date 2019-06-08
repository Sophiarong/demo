package com.example.demo.dao;

import com.example.demo.entity.IndexModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexRepos extends JpaRepository<IndexModel,String> {
    List<IndexModel> findAll();
}
