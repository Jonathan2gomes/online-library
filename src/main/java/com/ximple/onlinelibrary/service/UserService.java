package com.ximple.onlinelibrary.service;

import com.ximple.onlinelibrary.dto.UserDto;

import java.util.List;


public interface UserService {

    void save(UserDto user);

    UserDto findByUsername(String username);

    UserDto findById(Long id);

    List<UserDto> findAll();
}
