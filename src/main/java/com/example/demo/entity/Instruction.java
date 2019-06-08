package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/*
    实验参数的设置经过保存后再次被调出
 */
@Data
@Entity
public class Instruction {
    //只是作为ID，并没有什么用
    @Id
    @JsonIgnore
    @Column(name = "instruction_id")
    @Getter
    @Setter
    int insId;
//    @Column(name = "instruction_code")
//    @Getter
//    @Setter
//    int insCode;
    @JsonIgnore
    @Column(name = "instruction_status")
    @Getter
    @Setter
    int insStatus;
    //一旦用户修改，实验ID就会被废弃，建新的，因为它每天的意义不一样
    @JsonIgnore
    @Column(name = "experiment_id")
    @Getter
    @Setter
    String expId;
    @Column(name = "experiment_name")
    @Getter
    @Setter
    String expName;
    @Column(name = "instruction_send_time")
    @Getter
    @Setter
    Timestamp insSendTime;

    public String getInsPersonName() {
        return insPersonName;
    }

    public void setInsPersonName(String insPersonName) {
        this.insPersonName = insPersonName;
    }

    @Column(name = "user_name")
    @Getter
    @Setter
    String insPersonName;
    @Column(name = "box_id")
    @Getter
    @Setter
    int boxId;
    @Column(name = "plant_id")
    @Getter
    @Setter
    int plantId;
//    @Column(name = "light_id")
////    @Getter
////    @Setter
////    int lightId;
    @Column(name = "light_red")
    @Getter
    @Setter
    int lightRed;
    @Column(name = "light_blue")
    @Getter
    @Setter
    int lightBlue;
    @Column(name = "light_green")
    @Getter
    @Setter
    int lightGreen;
    @Column(name = "light_infrared")
    @Getter
    @Setter
    int lightInfrared;
    @Column(name = "light_ultraviolet")
    @Getter
    @Setter
    int lightUltraviolet;
    @Column(name = "light_white")
    @Getter
    @Setter
    int lightWhite;
    @Column(name = "box_temperature")
    @Getter
    @Setter
    int boxTemperature;
    @Column(name = "box_humidity")
    @Getter
    @Setter
    int boxHumidity;
    @Column(name = "box_co2")
    @Getter
    @Setter
    int boxCo2;
    @Column(name = "nutrient_id")
    @Getter
    @Setter
    int nutrientId;
    @Column(name = "sample_timeout")
    @Getter
    @Setter
    int sampleTimeout;
    @Column(name = "img_timeout")
    @Getter
    @Setter
    int imgTimeout;
}
