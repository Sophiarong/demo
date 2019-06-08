package com.example.demo.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class PastGrowDetail {
    @Id
    @Getter
    @Setter
    @Column(name = "pk1")
    int pk;
    @Getter
    @Setter
    @Column(name = "sample_time")
    Timestamp sampleTime;
    @Getter
    @Setter
    @Column(name = "plant_height1")
    int plantHeight1;
    @Getter
    @Setter
    @Column(name = "plant_height2")
    int plantHeight2;
    @Getter
    @Setter
    @Column(name = "plant_height3")
    int plantHeight3;
    @Getter
    @Setter
    @Column(name = "plant_height4")
    int plantHeight4;
    @Getter
    @Setter
    @Column(name = "blade_proportion")
    int bladeProportion;
}
