package com.example.demo.dao;

import com.example.demo.entity.plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepos extends JpaRepository<plant,String> {
    List<plant> findAll();
}
