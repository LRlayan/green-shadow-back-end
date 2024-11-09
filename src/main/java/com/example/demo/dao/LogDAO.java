package com.example.demo.dao;

import com.example.demo.entity.impl.CropEntity;
import com.example.demo.entity.impl.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDAO extends JpaRepository<LogEntity,String> {
}
