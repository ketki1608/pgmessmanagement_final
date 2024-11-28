package com.app.pgmessmanagement.service;

import com.app.pgmessmanagement.dto.UserDto;
import com.app.pgmessmanagement.exception.ResourceFoundException;
import com.app.pgmessmanagement.exception.ResourceNotFoundException;
import com.app.pgmessmanagement.model.User;
import com.app.pgmessmanagement.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userRepository.findByUserName(userDto.getUserName());
        if(user != null){
            throw new ResourceFoundException("Enter unique username");
        }
        return mapper.map(userRepository.save(mapper.map(userDto, User.class)), UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(user -> this.mapper.map(user, UserDto.class)).toList();
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = this.userRepository.findById(userDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));
        user.setUserName(userDto.getUserName());
        user.setWatchWord(userDto.getWatchWord());
        return mapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public void deleteUserById(Integer id) {
        this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));
        this.userRepository.deleteById(id);
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));
        return mapper.map(user, UserDto.class);
    }

    @Override
    public Object authenticateUser(UserDto userDto) {
        User user = userRepository.findByUserName(userDto.getUserName());
        if(user ==  null){
            // User name is invalid
            throw new ResourceNotFoundException("Invalid Credentials");
        }
        if(user.getWatchWord().equals(userDto.getWatchWord())){
            return "user is valid";
        }else {
            // Password is invalid
            return "Invalid Credentials";
        }
    }
}
