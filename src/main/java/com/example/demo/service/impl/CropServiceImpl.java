package com.example.demo.service.impl;

import com.example.demo.dao.CropDAO;
import com.example.demo.dto.CropStatus;
import com.example.demo.dto.impl.CropDTO;
import com.example.demo.entity.impl.CropEntity;
import com.example.demo.exception.DataPersistException;
import com.example.demo.service.CropService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CropServiceImpl implements CropService {
    @Autowired
    private CropDAO cropDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveCrop(CropDTO cropDTO) {
        CropEntity saveCrop = cropDAO.save(mapping.toCropEntity(cropDTO));

        if (saveCrop == null){
            throw new DataPersistException("Crop is not saved.");
        }
    }

    @Override
    public List<CropDTO> getAllCrop() {
        List<CropEntity> getAllCrops = cropDAO.findAll();
        return mapping.cropList(getAllCrops);
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
