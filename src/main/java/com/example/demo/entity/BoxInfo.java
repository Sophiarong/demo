package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
/*
    卡片页用到的箱子的实时环境参数
 */
@Data
@Entity
@Table(name="cardview")
public class BoxInfo {
    @Column(name = "experiment_name")
    private String experimentName;
    @Column(name = "experiment_id")
    private String experimentId;
    @Column(name = "currenttime")
    private Timestamp currentTime;
    @Id
    @Column(name = "box_id")
    private int boxId;
    @Column(name = "box_temperature")
    private int temperature;
    @Column(name = "box_humidity")
    private int humidity;
    @Column(name = "box_co2")
    private int co2;
    @Column(name = "nutrient_ph")
    private int ph;
    @Column(name = "nutrient_ec")
    private int ec;
    @Column(name = "light_red")
    private int lightRed;
    @Column(name = "light_blue")
    private int lightBlue;
    @Column(name = "light_green")
    private int lightGreen;
    @Column(name = "light_infrared")
    private int lightInfrared;
    @Column(name = "light_ultraviolet")
    private int lightUltraviolet;
    @Column(name = "light_white")
    private int lightWhite;
}
