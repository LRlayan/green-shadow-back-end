package com.example.demo.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity {
    @Id
    private String equipmentCode;
    private String Name;
    private String type;
    private String status;
    private String availableCount;
    @OneToMany(mappedBy = "staffEntity",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<StaffEquipmentDetails> staffEquipmentDetailsList;
    @ManyToMany
    private List<FieldEntity> fieldList;
}
