package com.example.demo.dao;

import com.example.demo.entity.ExpPastForPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpPastForPageRepos extends JpaRepository<ExpPastForPage,String> {
}
