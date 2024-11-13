package com.example.demo.dto.impl;

import com.example.demo.dto.CropStatus;
import com.example.demo.dto.SuperDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CropDTO implements SuperDTO,CropStatus {
    @Id
    private String cropCode;
    private String cropName;
    private String scientificName;
    private String category;
    private String season;
    private String cropImage;
    @JsonIgnore
    private List<LogDTO> logList;
    private List<FieldDTO> fieldList;
}
