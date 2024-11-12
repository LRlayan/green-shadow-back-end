package com.example.demo.service.impl;

import com.example.demo.dao.CropDAO;
import com.example.demo.dao.FieldDAO;
import com.example.demo.dto.CropStatus;
import com.example.demo.dto.impl.CropDTO;
import com.example.demo.dto.impl.FieldDTO;
import com.example.demo.entity.impl.CropEntity;
import com.example.demo.entity.impl.FieldEntity;
import com.example.demo.exception.DataPersistException;
import com.example.demo.service.CropService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CropServiceImpl implements CropService {
    @Autowired
    private CropDAO cropDAO;
    @Autowired
    private FieldDAO fieldDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveCrop(CropDTO cropDTO) {
        int number = 0;
        CropEntity crop = cropDAO.findLastRowNative();
        if (crop != null){
            String[] parts = crop.getCropCode().split("-");
            number = Integer.parseInt(parts[1]);
        }
        cropDTO.setCropCode("CROP-" + ++number);
        CropEntity cropEntity = mapping.toCropEntity(cropDTO);
        List<FieldEntity> fieldEntities = new ArrayList<>();
        for (FieldDTO fieldDTO : cropDTO.getFieldList()){
            if (fieldDAO.existsById(fieldDTO.getFieldCode())){
                fieldEntities.add(fieldDAO.getReferenceById(fieldDTO.getFieldCode()));
            }
        }
        cropEntity.setFieldList(fieldEntities);
        for (FieldEntity fieldEntity : fieldEntities){
            fieldEntity.getCropList().add(cropEntity);
        }
        cropDAO.save(cropEntity);
        if (cropEntity == null){
            throw new DataPersistException("Crop is not saved.");
        }
    }

    @Override
    public List<CropDTO> getAllCrop() {
        return mapping.cropList(cropDAO.findAll());
    }

    @Override
    public void deleteCrop(String id) {

    }

    @Override
    public void updateCrop(String id, CropDTO cropDTO) {

    }

    @Override
    public CropStatus getSelectedCrop(String cropId) {
        return null;
    }
}
