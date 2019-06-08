package com.example.demo.entity;

import lombok.Data;
/*
    接收前端的数据
 */
@Data
public class GetBoxIns {
    private int boxId;
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
}
