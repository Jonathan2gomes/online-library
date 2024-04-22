package com.ximple.onlinelibrary.service;

import com.ximple.onlinelibrary.dto.UserDto;
import com.ximple.onlinelibrary.exception.NotFoundException;
import com.ximple.onlinelibrary.mapper.UserMapper;
import com.ximple.onlinelibrary.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public void save(UserDto user) {
        userRepository.save(userMapper.toEntity(user));
    }

    @Override
    public UserDto findByUsername(String name) {
        return userMapper.toDto(userRepository.findByName(name).stream().findFirst()
                .orElseThrow(() -> new NotFoundException("User not found")));
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found")));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDtoList(userRepository.findAll());
    }
}
