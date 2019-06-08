package com.example.demo.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
/*
    用在首页的箱子详情
 */
@Data
@Entity
@Table(name="homeview")
public class IndexModel {
    @Id
    @Column(name = "box_id")
    public int boxId;
    @Column(name = "experiment_id")
    public String expId;
    @Column(name = "currenttime")
    public Timestamp currentTime;
    @Column(name = "experiment_name")
    public String expName;
    @Column(name = "user_name")
    public String userName;
    @Column(name = "start_time")
    public Timestamp startTime;
    @Column(name = "plant_height1")
    public int plantHeight1;
    @Column(name = "plant_height2")
    public int plantheight2;
    @Column(name = "plant_height3")
    public int plantHeight3;
    @Column(name = "plant_height4")
    public int plantHeight4;
    @Column(name = "blade_proportion")
    public int bladeProportion;
}
