package com.example.demo.controller;

import com.example.demo.dto.FieldStatus;
import com.example.demo.dto.impl.CropDTO;
import com.example.demo.dto.impl.FieldDTO;
import com.example.demo.dto.impl.StaffDTO;
import com.example.demo.exception.DataPersistException;
import com.example.demo.service.FieldService;
import com.example.demo.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/fields")
public class FieldController {
    @Autowired
    private FieldService fieldService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("name") String fieldName,
            @RequestPart("location") String location,
            @RequestPart("extentSize") double extentSize,
            @RequestPart("fieldImage1") MultipartFile fieldImage1,
            @RequestPart("fieldImage2") MultipartFile fieldImage2,
            @RequestPart("staffList") List<StaffDTO> staffList,
            @RequestPart("cropList") List<CropDTO> cropList
    ) {
        try {
            var fieldDTO = new FieldDTO();
            fieldDTO.setFieldCode(AppUtil.generateCode("FIELD-"));
            fieldDTO.setName(fieldName);
            fieldDTO.setLocation(location(location));
            fieldDTO.setExtentSize(extentSize);
            fieldDTO.setFieldImage1(AppUtil.imageBase64(fieldImage1.getBytes()));
            fieldDTO.setFieldImage2(AppUtil.imageBase64(fieldImage2.getBytes()));
            fieldDTO.setStaffList(staffList);
            fieldDTO.setCropList(cropList);
            fieldService.saveField(fieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{fieldId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public FieldStatus getSelectedField(@PathVariable("fieldId") String fieldId){
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDTO> getAllField(){
        return fieldService.getAllField();
    }

    @DeleteMapping(value = "/{fieldId}")
    public ResponseEntity<Void> deleteField(@PathVariable ("fieldId") String fieldId){
        return null;
    }

    @PutMapping(value = "/{fieldId}")
    public void updateField(@PathVariable("fieldId") String fieldId) throws IOException {

    }

    private Point location(String location){
        String[] locationParts = location.split(",");
        double longitude = Double.parseDouble(locationParts[0].trim());
        double latitude = Double.parseDouble(locationParts[1].trim());
        return new Point(longitude, latitude);
    }
}
