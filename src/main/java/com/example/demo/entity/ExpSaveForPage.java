package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/*
    用来放 被保存了的实验
    对应expsaveview
 */
@Data
@Entity
@Table(name = "expsaveview")
public class ExpSaveForPage {
    @Getter
    @Setter
    @Column(name = "experiment_name")
    String expName;
    @Id
    @Getter
    @Setter
    @Column(name = "experiment_id")
    String expId;
    @Getter
    @Setter
    @Column(name = "save_time")
    Timestamp saveTime;
    @Setter
    @Getter
    @Column(name = "user_name")
    String userName;
}
