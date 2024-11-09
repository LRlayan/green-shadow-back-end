package com.example.demo.service;

import com.example.demo.dto.UserStatus;
import com.example.demo.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUser();
    void deleteUser(String id);
    void updateUser(String id, UserDTO userDTO);
    UserStatus getSelectedUser(String id);
}
