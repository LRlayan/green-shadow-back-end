package com.example.demo.service.impl;

import com.example.demo.customStatusCode.SelectedErrorStatus;
import com.example.demo.dao.FieldDAO;
import com.example.demo.dto.FieldStatus;
import com.example.demo.dto.impl.*;
import com.example.demo.entity.impl.*;
import com.example.demo.exception.DataPersistException;
import com.example.demo.service.FieldService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.ArrayList;
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

        FieldEntity fieldEntity = mapping.toFieldEntity(fieldDTO);
        fieldEntity.setLocation(location(fieldDTO.getLocation()));
        FieldEntity saveField = fieldDAO.save(fieldEntity);
        if (saveField == null){
            throw new DataPersistException("Field is not saved.");
        }
    }

    @Override
    public List<FieldDTO> getAllField() throws IOException, ClassNotFoundException {
        List<FieldDTO> fieldDTOS = new ArrayList<>();
        for (FieldEntity fieldEntity : fieldDAO.findAll()){
            List<EquipmentDTO> equipmentDTOS =  new ArrayList<>();
            List<StaffDTO> staffDTOS =  new ArrayList<>();
            List<LogDTO> logDTOS =  new ArrayList<>();
            List<CropDTO> cropDTOS =  new ArrayList<>();

            for (CropEntity cropEntity : fieldEntity.getCropList()){
                cropDTOS.add(new CropDTO(cropEntity.getCropCode(),cropEntity.getCropName(),cropEntity.getScientificName(),cropEntity.getCategory(),cropEntity.getSeason(),cropEntity.getCropImage(),new ArrayList<>(),new ArrayList<>()));
            }
            fieldDTOS.add(new FieldDTO(fieldEntity.getFieldCode(), fieldEntity.getName(), convertPointToLocation(fieldEntity.getLocation()), fieldEntity.getExtentSize(), fieldEntity.getFieldImage1(),fieldEntity.getFieldImage2(),equipmentDTOS,staffDTOS,logDTOS,cropDTOS));
        }
        return fieldDTOS;
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

    public String convertPointToLocation(Point point) {
        if (point != null) {
            return point.getX() + "," + point.getY(); // Format as "longitude,latitude"
        }
        return "";
    }

    private Point location(String location){
        String[] locationParts = location.split(",");
        double longitude = Double.parseDouble(locationParts[0].trim());
        double latitude = Double.parseDouble(locationParts[1].trim());
        return new Point(longitude, latitude);
    }
}
