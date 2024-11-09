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
@Table(name = "staffEquipmentDetails")
public class StaffEquipmentDetails {
    @Id
    private String id;
    private int useEquipmentCount;
}
