package com.example.demo.service.impl;

import com.example.demo.dao.VehicleDAO;
import com.example.demo.dto.VehicleStatus;
import com.example.demo.dto.impl.VehicleDTO;
import com.example.demo.entity.impl.CropEntity;
import com.example.demo.entity.impl.VehicleEntity;
import com.example.demo.exception.DataPersistException;
import com.example.demo.service.VehicleService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDAO vehicleDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        int number = 0;
        VehicleEntity vehicle = vehicleDAO.findLastRowNative();
        if (vehicle != null){
            String[] parts = vehicle.getVehicleCode().split("-");
            number = Integer.parseInt(parts[1]);
        }
        vehicleDTO.setVehicleCode("VEHICLE-" + ++number);

        VehicleEntity vehicleEntity = vehicleDAO.save(mapping.toVehicleEntity(vehicleDTO));
        if (vehicleEntity == null){
            throw new DataPersistException("vehicle not saved");
        }
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
