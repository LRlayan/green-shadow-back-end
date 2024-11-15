package com.example.demo.service.impl;

import com.example.demo.dao.EquipmentDAO;
import com.example.demo.dto.EquipmentStatus;
import com.example.demo.dto.impl.CropDTO;
import com.example.demo.dto.impl.EquipmentDTO;
import com.example.demo.entity.impl.EquipmentEntity;
import com.example.demo.exception.DataPersistException;
import com.example.demo.service.EquipmentService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentDAO equipmentDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        int number = 0;
        EquipmentEntity equipment = equipmentDAO.findLastRowNative();
        if (equipment != null){
            String[] parts = equipment.getEquipmentCode().split("-");
            number = Integer.parseInt(parts[1]);
        }
        equipmentDTO.setEquipmentCode("EQUIPMENT-" + ++number);
        EquipmentEntity equipmentEntity = equipmentDAO.save(mapping.toEquipmentEntity(equipmentDTO));
        if (equipmentEntity == null){
            throw new DataPersistException("Equipment not saved!");
        }
    }

    @Override
    public List<EquipmentDTO> getAllEquipment() {
        return mapping.equipmentList(equipmentDAO.findAll());
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
