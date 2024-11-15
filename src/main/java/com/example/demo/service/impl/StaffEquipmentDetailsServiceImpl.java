package com.example.demo.service.impl;

import com.example.demo.dao.StaffEquipmentDetailsDAO;
import com.example.demo.dto.StaffEquipmentDetailsStatus;
import com.example.demo.dto.impl.StaffEquipmentDetailsDTO;
import com.example.demo.entity.impl.StaffEquipmentDetailsEntity;
import com.example.demo.service.StaffEquipmentDetailsService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffEquipmentDetailsServiceImpl implements StaffEquipmentDetailsService {
    @Autowired
    private StaffEquipmentDetailsDAO staffEquipmentDetailsDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveStaffEquipmentDetails(StaffEquipmentDetailsDTO equipmentDetailsDTO) {
        int number = 0;
        StaffEquipmentDetailsEntity staffEquipmentDetails = staffEquipmentDetailsDAO.findLastRowNative();
        if (staffEquipmentDetails != null){
            String[] parts = staffEquipmentDetails.getId().split("-");
            number = Integer.parseInt(parts[1]);
        }
        equipmentDetailsDTO.setId("STEQDET-" + ++number);
        if (equipmentDetailsDTO == null){
            System.out.println("null dto ==========================");
        }
        System.out.println(equipmentDetailsDTO);
        staffEquipmentDetailsDAO.save(mapping.toStaffEquDetailsEntity(equipmentDetailsDTO));
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
