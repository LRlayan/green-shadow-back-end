package com.example.demo.service.impl;

import com.example.demo.dto.StaffStatus;
import com.example.demo.dto.impl.StaffDTO;
import com.example.demo.service.StaffService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Override
    public void saveStaffMember(StaffDTO staffDTO) {

    }

    @Override
    public List<StaffDTO> getAllStaffMember() {
        return null;
    }

    @Override
    public void deleteStaffMember(String staffId) {

    }

    @Override
    public void updateStaffMember(String id, StaffDTO staffDTO) {

    }

    @Override
    public StaffStatus getSelectedStaffMember(String staffId) {
        return null;
    }
}
