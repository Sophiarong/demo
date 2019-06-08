package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.sql.Timestamp;

/*
    用于折线图
 */
@Data
@Entity
@IdClass(com.example.demo.entity.IdClass.class)
public class GrowDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "experiment_id")
    private String experimentId;
    @Id
    @Column(name = "box_id")
    private int boxId;
    @Column(name = "sample_time")
    private Timestamp sampleTime;
    @Column(name = "plant_height1")
    private int plantHeight1;
    @Column(name = "plant_height2")
    private int plantHeight2;
    @Column(name = "plant_height3")
    private int plantHeight3;
    @Column(name = "plant_height4")
    private int plantHeight4;
    @Column(name = "blade_proportion")
    private int bladeProportion;
    @JsonIgnore
    @Id
    @Column(name = "pk1")
    private int pk;
}
