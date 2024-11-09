package com.example.demo.service.impl;

import com.example.demo.dto.CropStatus;
import com.example.demo.dto.impl.CropDTO;
import com.example.demo.service.CropService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CropServiceImpl implements CropService {
    @Override
    public void saveCrop(CropDTO cropDTO) {

    }

    @Override
    public List<CropDTO> getAllCrop() {
        return null;
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
