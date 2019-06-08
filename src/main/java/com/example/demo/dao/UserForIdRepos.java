package com.example.demo.dao;

import com.example.demo.entity.UserForId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserForIdRepos extends JpaRepository<UserForId,String> {
    @Query(nativeQuery = true,value = "select instruction_person_id from instruction_info where instruction_id = ?1")
    List<Integer> userForId(int instructionId);
}
