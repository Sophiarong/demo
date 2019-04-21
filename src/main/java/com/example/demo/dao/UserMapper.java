package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {

//    @Select("select * from user where id = #{id}")
//    public User selectUserById(int id);

    @Select("select * from user where userName = #{userName}")
    public User login(@Param("userName")String username, @Param("password")String password);

//    @Insert("insert into user(userName,userAge,userAddress) values (#{userName},#{userAge},#{userAddress})")
//    public void addUser(User user);
//
//    @Update("update user set userName=#{userName},userAge=#{userAge},userAddress=#{userAddress} where id=#{id}")
//    public void updateUser(User user);
//
//    @Delete("delete from user where id=#{id}")
//    public void deleteUser(int id);

}
