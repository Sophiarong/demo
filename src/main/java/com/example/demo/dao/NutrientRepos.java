package com.example.demo.dao;

import com.example.demo.entity.Nutrient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutrientRepos extends JpaRepository<Nutrient,String> {
    List<Nutrient> findAll();
}
