package com.example.demo.service;

import com.example.demo.dto.FieldStatus;
import com.example.demo.dto.impl.CropDTO;
import com.example.demo.dto.impl.FieldDTO;

import java.io.IOException;
import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    List<FieldDTO> getAllField() throws IOException, ClassNotFoundException;
    void deleteField(String id);
    void updateField(String id,CropDTO fieldDTO);
    FieldStatus getSelectedField(String fieldId);
}
