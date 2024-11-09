package com.example.demo.dto.impl;

import com.example.demo.dto.SuperDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffEquipmentDetailsDTO implements SuperDTO {
    @Id
    private String id;
    private int useEquipmentCount;
    private StaffDTO staffEntity;
    private EquipmentDTO equipmentEntity;
}
