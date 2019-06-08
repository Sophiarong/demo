package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
    用在首页的全体箱子
 */
@Data
@Entity
@Table(name="box_info")
public class Box {
    @Id
    @Column(name = "box_id")
    @Getter
    @Setter
    int boxId;
    @Column(name = "box_status")
    @Getter
    @Setter
    int boxStatus;
    @Column(name = "experiment_id")
    @Getter
    @Setter
    String expId;
}
