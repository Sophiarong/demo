package com.example.demo.dao;

import com.example.demo.entity.ExpRunningForPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpRunningForPageRepos  extends JpaRepository<ExpRunningForPage,String> {

}
