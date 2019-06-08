package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
public class UserForId {
    @Id
    @Column(name = "instrucction_person_id")
    int userId;
}
