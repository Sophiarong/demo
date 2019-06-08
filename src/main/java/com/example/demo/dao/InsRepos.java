package com.example.demo.dao;

import com.example.demo.entity.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsRepos extends JpaRepository<Instruction,String> {

}
