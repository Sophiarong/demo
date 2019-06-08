package com.example.demo.entity;

import lombok.Data;

import java.util.List;
/*
    接收前端的数据
 */
@Data
public class GetIns {
    private String experimentName;
    private int experimentPersonId;
    private int insStatus;
    private int plantId;
    private String expPurpose;
    private String expDescription;
    private String expAddress;
    private int sampleTimeout;
    private int imgTimeout;
    List<GetBoxIns> boxes;
}
