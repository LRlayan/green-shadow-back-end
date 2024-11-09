package com.example.demo.service.impl;

import com.example.demo.dto.VehicleStatus;
import com.example.demo.dto.impl.VehicleDTO;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {

    }

    @Override
    public List<VehicleDTO> getAllVehicle() {
        return null;
    }

    @Override
    public void deleteVehicle(String id) {

    }

    @Override
    public void updateVehicle(String id, VehicleDTO vehicleDTO) {

    }

    @Override
    public VehicleStatus getSelectedVehicle(String id) {
        return null;
    }
}
