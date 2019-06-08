package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/*
    定义生长折线图实体类(GrowDetail)需要用到的复合主键
 */
@Data
public class IdClass implements Serializable {
    @Getter
    @Setter
    private String experimentId;
    @Getter
    @Setter
    private int boxId;
    @Getter
    @Setter
    private int pk;
}
