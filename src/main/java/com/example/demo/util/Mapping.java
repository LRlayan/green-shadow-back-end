package com.example.demo.util;

import com.example.demo.dto.impl.*;
import com.example.demo.entity.impl.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    ModelMapper modelMapper;

    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,UserEntity.class);
    }

    public UserDTO toUserDTO(UserEntity userentity){
        return modelMapper.map(userentity,UserDTO.class);
    }

    public List<UserDTO> userList(List<UserEntity> userList){
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public CropEntity toCropEntity(CropDTO cropDTO){
        return modelMapper.map(cropDTO,CropEntity.class);
    }

    public CropDTO toCropDTO(CropEntity cropEntity){
        return modelMapper.map(cropEntity,CropDTO.class);
    }

    public List<CropDTO> cropList(List<CropEntity> cropList){
        return modelMapper.map(cropList,new TypeToken<List<CropDTO>>(){}.getType());
    }

    public EquipmentEntity toEquipmentEntity(EquipmentDTO equipmentDTO){
        return modelMapper.map(equipmentDTO,EquipmentEntity.class);
    }

    public EquipmentDTO toEquipmentDTO(EquipmentEntity equipmentEntity){
        return modelMapper.map(equipmentEntity,EquipmentDTO.class);
    }

    public List<EquipmentDTO> equipmentList(List<EquipmentDTO> equipmentDTO){
        return modelMapper.map(equipmentDTO,new TypeToken<List<EquipmentDTO>>(){}.getType());
    }
}
