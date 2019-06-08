package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends JpaRepository<User, String> {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(User record);
//
//    int insertSelective(User record);

//    User selectByPrimaryKey(String id);
    User findByUsername(String username);

//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);

//    ArrayList<User> selectAll();
}
