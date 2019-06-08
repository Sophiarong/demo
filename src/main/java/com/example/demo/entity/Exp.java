package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Exp {
    @Id
    @Column(name = "experiment_id")
    String expId;
    @Column(name = "plant_id")
    int plantId;
    @Column(name = "experiment_name")
    String expName;
    @Column(name = "start_time")
    Timestamp startTime;
    //为了复用，正在进行的话这个endtime可以不理它
    @Column(name = "end_time")
    Timestamp endTime;
    @Column(name = "experiment_purpose")
    String expPurpose;
    @Column(name = "experiment_description")
    String expDescription;
    @Column(name = "experiment_address")
    String expAddress;
    @Column(name = "user_name")
    String username;
    @Column(name = "experiment_record")
    String expRecord;
    @Column(name = "experiment_status")
    int expStatus;
    //为了复用，正在进行的话可以不理它
    @Column(name = "experiment_result")
    String expResult;
}
