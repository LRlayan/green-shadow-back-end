package com.example.demo.dto.impl;

import com.example.demo.dto.LogStatus;
import com.example.demo.dto.SuperDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogDTO implements SuperDTO , LogStatus {
    @Id
    private String logCode;
    private String date;
    private String logDetails;
    private String observedImage;
    private List<StaffDTO> staffList;
    private List<CropDTO> cropList;
    @JsonIgnore
    private List<FieldDTO> fieldList;
}
