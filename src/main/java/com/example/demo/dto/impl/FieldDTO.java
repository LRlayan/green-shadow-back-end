package com.example.demo.dto.impl;

import com.example.demo.dto.FieldStatus;
import com.example.demo.dto.SuperDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.geo.Point;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FieldDTO implements SuperDTO, FieldStatus {
    @Id
    private String fieldCode;
    private String name;
    private String location;
    private double extentSize;
    private String fieldImage1;
    private String fieldImage2;
    @JsonIgnore
    private List<EquipmentDTO> equipmentsList;
    @JsonIgnore
    private List<StaffDTO> staffList;
    @JsonIgnore
    private List<LogDTO> logList;
    private List<CropDTO> cropList;
}
