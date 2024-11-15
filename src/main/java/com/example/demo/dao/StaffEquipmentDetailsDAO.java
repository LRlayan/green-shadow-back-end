package com.example.demo.dao;

import com.example.demo.entity.impl.StaffEquipmentDetailsEntity;
import com.example.demo.entity.impl.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffEquipmentDetailsDAO extends JpaRepository<StaffEquipmentDetailsEntity,String> {
    @Query(value = "SELECT * FROM staff_equipment_details WHERE id = (SELECT id FROM staff_equipment_details ORDER BY CAST(SUBSTRING(id, 8) AS UNSIGNED) DESC LIMIT 1);", nativeQuery = true)
    StaffEquipmentDetailsEntity findLastRowNative();
}
