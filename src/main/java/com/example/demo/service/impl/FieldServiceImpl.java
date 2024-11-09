package com.example.demo.service.impl;

import com.example.demo.dto.FieldStatus;
import com.example.demo.dto.impl.CropDTO;
import com.example.demo.dto.impl.FieldDTO;
import com.example.demo.service.FieldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FieldServiceImpl implements FieldService {
    @Override
    public void saveField(FieldDTO fieldDTO) {

    }

    @Override
    public List<FieldDTO> getAllField() {
        return null;
    }

    @Override
    public void deleteField(String id) {

    }

    @Override
    public void updateField(String id, CropDTO fieldDTO) {

    }

    @Override
    public FieldStatus getSelectedField(String fieldId) {
        return null;
    }
}
