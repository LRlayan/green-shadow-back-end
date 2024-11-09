package com.example.demo.service.impl;

import com.example.demo.dto.LogStatus;
import com.example.demo.dto.impl.CropDTO;
import com.example.demo.dto.impl.LogDTO;
import com.example.demo.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Override
    public void saveLog(LogDTO logDTO) {

    }

    @Override
    public List<LogDTO> getAllLog() {
        return null;
    }

    @Override
    public void deleteLog(String id) {

    }

    @Override
    public void updateLog(String id, CropDTO logDTO) {

    }

    @Override
    public LogStatus getSelectedLog(String logId) {
        return null;
    }
}
