package com.example.demo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.user.domain.UserRequestDTO;
import com.example.demo.user.domain.UserResponseDTO;
import com.example.demo.user.dao.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    
    public UserResponseDTO login(UserRequestDTO params){
        System.out.println("debug >>> UserService login ");
        return userMapper.loginRow(params);
    }

    public void join(UserRequestDTO params, MultipartFile file){
        System.out.println("debug >>> UserService join ");
        System.out.println("debug >>> upload img : "+ file.getOriginalFilename());
        // userMapper.joinRow(params);
    }
}
