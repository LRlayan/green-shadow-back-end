package com.example.demo.service;

import com.example.demo.dto.CropStatus;
import com.example.demo.dto.impl.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    List<CropDTO> getAllCrop();
    void deleteCrop(String id);
    void updateCrop(String id,CropDTO cropDTO);
    CropStatus getSelectedCrop(String cropId);
}