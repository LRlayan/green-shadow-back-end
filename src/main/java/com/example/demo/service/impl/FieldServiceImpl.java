package com.example.demo.service.impl;

import com.example.demo.customStatusCode.SelectedErrorStatus;
import com.example.demo.dao.FieldDAO;
import com.example.demo.dto.FieldStatus;
import com.example.demo.dto.impl.CropDTO;
import com.example.demo.dto.impl.FieldDTO;
import com.example.demo.entity.impl.FieldEntity;
import com.example.demo.exception.DataPersistException;
import com.example.demo.service.FieldService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldDAO fieldDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveField(FieldDTO fieldDTO) {
        int number = 0;
        FieldEntity field = fieldDAO.findLastRowNative();
        if (field != null){
            String[] parts = field.getFieldCode().split("-");
            number = Integer.parseInt(parts[1]);
        }
        fieldDTO.setFieldCode("FIELD-" + ++number);
        FieldEntity saveField = fieldDAO.save(mapping.toFieldEntity(fieldDTO));
        if (saveField == null){
            throw new DataPersistException("Field is not saved.");
        }
    }

    @Override
    public List<FieldDTO> getAllField() {
        return mapping.fieldList(fieldDAO.findAll());
//        return mapping.fieldList(fieldDAO.findAllWithCrops());
    }

    @Override
    public void deleteField(String id) {

    }

    @Override
    public void updateField(String id, CropDTO fieldDTO) {

    }

    @Override
    public FieldStatus getSelectedField(String fieldId) {
        if (fieldDAO.existsById(fieldId)){
            return mapping.toFieldDTO(fieldDAO.getReferenceById(fieldId));
        }else {
            return new SelectedErrorStatus(2,"Field with Code "+fieldId+" not found");
        }
    }
}
