package com.example.demo.dao;

import com.example.demo.entity.impl.CropEntity;
import com.example.demo.entity.impl.StaffEquipmentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffEquipmentDetailsDAO extends JpaRepository<StaffEquipmentDetailsEntity,String> {
}
