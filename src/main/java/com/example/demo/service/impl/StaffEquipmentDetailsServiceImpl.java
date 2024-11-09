package com.example.demo.service.impl;

import com.example.demo.dto.StaffEquipmentDetailsStatus;
import com.example.demo.dto.impl.StaffEquipmentDetailsDTO;
import com.example.demo.service.StaffEquipmentDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffEquipmentDetailsServiceImpl implements StaffEquipmentDetailsService {
    @Override
    public void saveStaffEquipmentDetails(StaffEquipmentDetailsDTO equipmentDetailsDTO) {

    }

    @Override
    public List<StaffEquipmentDetailsDTO> getAllStaffEquipmentDetails() {
        return null;
    }

    @Override
    public void deleteStaffEquipmentDetails(String staffId) {

    }

    @Override
    public void updateStaffEquipmentDetails(String staffId, StaffEquipmentDetailsDTO equipmentDetailsDTO) {

    }

    @Override
    public StaffEquipmentDetailsStatus getSelectedStaffEquipmentDetails(String staffId) {
        return null;
    }
}
