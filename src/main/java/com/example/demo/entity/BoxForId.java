package com.example.demo.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class BoxForId {
    @Id
    @Column(name = "box_id")
    @Getter
    @Setter
    int boxId;
}
