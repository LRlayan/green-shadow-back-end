package com.example.demo.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "field")
public class FieldEntity {
    @Id
    private String fieldCode;
    private String name;
    private String location;
    private String extentSize;
    private String fieldImage1;
    private String fieldImage2;
}