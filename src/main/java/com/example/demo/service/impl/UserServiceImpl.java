package com.example.demo.service.impl;

import com.example.demo.dto.UserStatus;
import com.example.demo.dto.impl.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(UserDTO userDTO) {

    }

    @Override
    public List<UserDTO> getAllUser() {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void updateUser(String id, UserDTO userDTO) {

    }

    @Override
    public UserStatus getSelectedUser(String id) {
        return null;
    }
}
