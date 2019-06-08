package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/*
    一个简单的实体，用来生成实验编号的
 */
@Data
@Entity
public class ExpForId {
    @Id
    @Column(name = "experiment_id")
    @Getter
    @Setter
    String expId;
}
