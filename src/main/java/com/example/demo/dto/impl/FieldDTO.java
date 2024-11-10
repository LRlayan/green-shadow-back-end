package com.example.demo.dto.impl;

import com.example.demo.dto.FieldStatus;
import com.example.demo.dto.SuperDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO implements SuperDTO, FieldStatus {
    @Id
    private String fieldCode;
    private String name;
    private Point location;
    private double extentSize;
    private String fieldImage1;
    private String fieldImage2;
    private List<EquipmentDTO> equipmentsList;
    private List<StaffDTO> staffList;
    private List<LogDTO> logList;
    private List<CropDTO> cropList;
}
