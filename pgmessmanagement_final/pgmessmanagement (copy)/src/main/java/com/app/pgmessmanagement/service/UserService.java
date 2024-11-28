package com.app.pgmessmanagement.service;

import com.app.pgmessmanagement.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    void deleteUserById(Integer id);

    UserDto getUserById(Integer id);

    Object authenticateUser(UserDto userDto);
}
