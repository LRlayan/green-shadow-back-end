package com.example.demo.service;

import com.example.demo.dto.LogStatus;
import com.example.demo.dto.impl.CropDTO;
import com.example.demo.dto.impl.LogDTO;

import java.util.List;

public interface LogService {
    void saveLog(LogDTO logDTO);
    List<LogDTO> getAllLog();
    void deleteLog(String id);
    void updateLog(String id, CropDTO logDTO);
    LogStatus getSelectedLog(String logId);
}
