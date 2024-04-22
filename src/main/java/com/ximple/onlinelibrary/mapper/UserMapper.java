package com.ximple.onlinelibrary.mapper;

import com.ximple.onlinelibrary.dto.UserDto;
import com.ximple.onlinelibrary.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getRegistration());
    }

    public User toEntity(UserDto userDto) {
        return new User(userDto.name(), userDto.email(), userDto.registration());
    }

    public List<UserDto> toDtoList(List<User> users) {
        return users.stream().map(this::toDto).toList();
    }
}
