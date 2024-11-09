package com.example.demo.service.impl;

import com.example.demo.dto.EquipmentStatus;
import com.example.demo.dto.impl.CropDTO;
import com.example.demo.dto.impl.EquipmentDTO;
import com.example.demo.service.EquipmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {
    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {

    }

    @Override
    public List<EquipmentDTO> getAllEquipment() {
        return null;
    }

    @Override
    public void deleteEquipment(String id) {

    }

    @Override
    public void updateEquipment(String id, CropDTO equipmentDTO) {

    }

    @Override
    public EquipmentStatus getSelectedEquipment(String equipmentId) {
        return null;
    }
}
