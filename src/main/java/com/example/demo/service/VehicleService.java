package com.example.demo.service;

import com.example.demo.dto.VehicleStatus;
import com.example.demo.dto.impl.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAllVehicle();
    void deleteVehicle(String id);
    void updateVehicle(String id, VehicleDTO vehicleDTO);
    VehicleStatus getSelectedVehicle(String id);
}
