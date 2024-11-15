package com.example.demo.service.impl;

import com.example.demo.dao.StaffDAO;
import com.example.demo.dto.StaffStatus;
import com.example.demo.dto.impl.StaffDTO;
import com.example.demo.dto.impl.StaffEquipmentDetailsDTO;
import com.example.demo.entity.impl.StaffEntity;
import com.example.demo.exception.DataPersistException;
import com.example.demo.service.StaffService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private StaffEquipmentDetailsServiceImpl staffEquipmentDetailsService;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveStaffMember(StaffDTO staffDTO) {
        int number = 0;
        StaffEntity staff = staffDAO.findLastRowNative();
        if (staff != null){
            String[] parts = staff.getMemberCode().split("-");
            number = Integer.parseInt(parts[1]);
        }
        staffDTO.setMemberCode("MEMBER-" + ++number);
        for (StaffEquipmentDetailsDTO staffEquipmentDetailsDTO :staffDTO.getStaffEquipmentDetailsList()){
            staffEquipmentDetailsDTO.setStaffEntity(new StaffDTO(staffDTO.getMemberCode()));
        }
        System.out.println("-----------------------------------------------------------------------------"+staffDTO.getStaffEquipmentDetailsList().size());
        StaffEquipmentDetailsDTO staffEqu = new StaffEquipmentDetailsDTO();
        for (StaffEquipmentDetailsDTO staffEquipmentDetailsDTO :staffDTO.getStaffEquipmentDetailsList()){
            System.out.println("staffEqu ========================== ");
            staffEqu.setStaffEntity(staffEquipmentDetailsDTO.getStaffEntity());
            staffEqu.setUseEquipmentCount(staffEquipmentDetailsDTO.getUseEquipmentCount());
            staffEqu.setEquipmentEntity(staffEquipmentDetailsDTO.getEquipmentEntity());
        }

        if (staffEqu == null){
            System.out.println("null staff equ ------------------------------------------------");
        }else {
            System.out.println("staff and equ details not null -------------------------------------");
            System.out.println("staff entity ---------------------- "+staffEqu.getStaffEntity());
            System.out.println("staff id ---------------------- "+staffEqu.getId());
            System.out.println("use count  ---------------------- "+staffEqu.getUseEquipmentCount());
            System.out.println("equip entity ---------------------- "+staffEqu.getEquipmentEntity());
        }

        StaffEntity staffEntity = mapping.toStaffEntity(staffDTO);
        staffEntity.setJoinedDate(toConvertLocalDate(staffDTO.getJoinedDate()));
        staffEntity.setDateOfBirth(toConvertLocalDate(staffDTO.getDateOfBirth()));
        staffEquipmentDetailsService.saveStaffEquipmentDetails(staffEqu);
        StaffEntity staffs = staffDAO.save(staffEntity);
        if (staffs == null){
            throw new DataPersistException("staff member not saved");
        }
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

    protected LocalDate toConvertLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        return LocalDate.parse(date,formatter);
    }
}
