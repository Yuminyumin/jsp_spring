package com.example.demo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.domain.UserRequestDTO;
import com.example.demo.user.domain.UserResponseDTO;
import com.example.demo.user.dao.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    
    public UserResponseDTO login(UserRequestDTO params){
        System.out.println("debug >>> UserService login");
        return userMapper.loginRow(params);
    }
}
