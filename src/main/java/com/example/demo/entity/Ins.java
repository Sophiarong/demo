package com.example.demo.entity;

import lombok.Data;
/*
    处理前端发过来的数据
 */
@Data
public class Ins {
    private String experimentName;
    private String experimentId;
    private int insStatus;
    private int insCode;
    private int instructionPersonId;
    private String expPurpose;
    private String expDescription;
    private String expAddress;
    private int boxId;
    private int plantId;
    private int lightId;
    private int lightRed;
    private int lightBlue;
    private int lightGreen;
    private int lightInfrared;
    private int lightUltraviolet;
    private int lightWhite;
    private int boxTemperature;
    private int boxHumidity;
    private int boxCo2;
    private int nutrientId;
    private int sampleTimeout;
    private int imgTimeout;
}
