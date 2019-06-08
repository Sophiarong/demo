package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "exppastview")
public class ExpPastForPage {
    @Getter
    @Setter
    @Column(name = "experiment_name")
    String expName;
    @Id
    @Getter
    @Setter
    @Column(name = "experiment_id")
    String expId;
    @Getter
    @Setter
    @Column(name = "start_time")
    Timestamp startTime;
    @Getter
    @Setter
    @Column(name = "end_time")
    Timestamp endTime;
    @Setter
    @Getter
    @Column(name = "user_name")
    String userName;
}
