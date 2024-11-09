package com.example.demo.controller;

import com.example.demo.dto.FieldStatus;
import com.example.demo.dto.impl.FieldDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/fields")
public class FieldController {
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveField() {
        return null;
    }

    @GetMapping(value = "/{fieldId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public FieldStatus getSelectedField(@PathVariable("fieldId") String fieldId){
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDTO> getAllField(){
        return null;
    }

    @DeleteMapping(value = "/{fieldId}")
    public ResponseEntity<Void> deleteField(@PathVariable ("fieldId") String fieldId){
        return null;
    }

    @PutMapping(value = "/{fieldId}")
    public void updateField(@PathVariable("fieldId") String fieldId) throws IOException {

    }
}
