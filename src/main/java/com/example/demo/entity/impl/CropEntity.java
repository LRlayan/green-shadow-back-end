package com.example.demo.entity.impl;

import com.example.demo.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "crop")
public class CropEntity implements SuperEntity {
    @Id
    private String cropCode;
    private String cropName;
    private String scientificName;
    private String category;
    private String season;
    private String cropImage;
    @ManyToMany(mappedBy = "cropList",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<LogEntity> logList;
    @ManyToMany(mappedBy = "cropList",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<FieldEntity> fieldList;
}
