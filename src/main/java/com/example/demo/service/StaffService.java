package com.example.demo.service;

import com.example.demo.dto.StaffStatus;
import com.example.demo.dto.impl.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaffMember(StaffDTO staffDTO);
    List<StaffDTO> getAllStaffMember();
    void deleteStaffMember(String staffId);
    void updateStaffMember(String id, StaffDTO staffDTO);
    StaffStatus getSelectedStaffMember(String staffId);
}
