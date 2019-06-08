package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "nutrient_info")
public class Nutrient {
    @Id
    @Column(name = "nutrient_id")
    int nutrientId;
    @Column(name = "nutrient_ph")
    int nutrientPh;
    @Column(name = "nutrient_ec")
    int nutrientEc;
    @Column(name = "nutrient_description")
    String description;
}
