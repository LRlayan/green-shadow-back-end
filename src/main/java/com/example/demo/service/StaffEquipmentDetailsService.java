package com.example.demo.service;

import com.example.demo.dto.StaffEquipmentDetailsStatus;
import com.example.demo.dto.impl.StaffEquipmentDetailsDTO;

import java.util.List;

public interface StaffEquipmentDetailsService {
    void saveStaffEquipmentDetails(StaffEquipmentDetailsDTO equipmentDetailsDTO);
    List<StaffEquipmentDetailsDTO> getAllStaffEquipmentDetails();
    void deleteStaffEquipmentDetails(String staffId);
    void updateStaffEquipmentDetails(String staffId, StaffEquipmentDetailsDTO equipmentDetailsDTO);
    StaffEquipmentDetailsStatus getSelectedStaffEquipmentDetails(String staffId);
}
