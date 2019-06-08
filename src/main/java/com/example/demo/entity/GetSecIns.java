package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class GetSecIns {
    private String experimentId;
    private String experimentName;
    private String expPurpose;
    private int plantId;
    private String expDescription;
    private String expAddress;
    private int experimentPersonId;
    private int insStatus;
    private int sampleTimeout;
    private int imgTimeout;
    List<GetBoxIns> boxes;
}
