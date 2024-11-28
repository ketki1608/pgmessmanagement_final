package com.app.pgmessmanagement.controller;

import com.app.pgmessmanagement.dto.UserDto;
import com.app.pgmessmanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/creatUser")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @GetMapping("/user/getUserList")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);

    }

    @PostMapping("/user/updateUser")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.updateUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id) {
        this.userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted successfully of id : " + id, HttpStatus.OK);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);

    }

    @PostMapping("/user/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<>(this.userService.authenticateUser(userDto), HttpStatus.CREATED);
    }

}
