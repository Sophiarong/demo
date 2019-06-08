package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "plant_info")
public class plant {
    @Id
    @Column(name = "plant_id")
    int plantId;
    @Column(name = "plant_name")
    String plantName;
    @Column(name = "plant_feature")
    String plantFeature;
}
