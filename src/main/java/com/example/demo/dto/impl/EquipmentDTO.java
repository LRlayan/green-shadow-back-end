package com.example.demo.dto.impl;

import com.example.demo.dto.EquipmentStatus;
import com.example.demo.dto.SuperDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDTO implements SuperDTO, EquipmentStatus {
    @Id
    private String equipmentCode;
    private String name;
    private String type;
    private String status;
    private int availableCount;
    private List<StaffEquipmentDetailsDTO> staffEquipmentDetailsList;
    private List<FieldDTO> fieldList;
}
