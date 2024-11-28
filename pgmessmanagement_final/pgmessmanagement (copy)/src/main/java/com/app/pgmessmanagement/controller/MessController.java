package com.app.pgmessmanagement.controller;

import com.app.pgmessmanagement.dto.MessDto;
import com.app.pgmessmanagement.dto.PgRequestDto;
import com.app.pgmessmanagement.dto.SearchDto;
import com.app.pgmessmanagement.model.Mess;
import com.app.pgmessmanagement.service.MessService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessController {
    @Autowired
    private MessService messService;

    @PostMapping("/mess/addMess")
    public ResponseEntity<MessDto> addMess(@Valid @RequestBody MessDto messDto) {
        MessDto createdDto = this.messService.addMess(messDto);
        return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
    }
    @PostMapping("/mess/updateMess")
    public ResponseEntity<MessDto> updateMess(@Valid @RequestBody MessDto messDto) {
        MessDto updatedDto = this.messService.updateMess(messDto);
        return new ResponseEntity<>(updatedDto, HttpStatus.CREATED);
    }

    @GetMapping("/mess/findAll")
    public ResponseEntity<List<MessDto>> findAllMess() {
        List<MessDto> updatedDto = this.messService.findAllMess();
        return new ResponseEntity<>(updatedDto, HttpStatus.CREATED);
    }

    @GetMapping("/mess/{id}")
    public ResponseEntity<MessDto> getMessById(@Valid @PathVariable Integer id) {
        MessDto updatedDto = this.messService.getMessById(id);
        return new ResponseEntity<>(updatedDto, HttpStatus.CREATED);
    }

    @GetMapping("/mess/user/{userId}")
    public ResponseEntity<?> getMessByuserId(@Valid @PathVariable Integer userId) {
        List<MessDto> updatedDto = this.messService.getMessByuserId(userId);
        return new ResponseEntity<>(updatedDto, HttpStatus.CREATED);
    }

    @PostMapping("/mess/searchByLoc")
    public ResponseEntity<List<MessDto>> searchByLocation(@Valid @RequestBody SearchDto messDto) {
        List<MessDto> updatedDto = this.messService.searchByLocation(messDto);
        return new ResponseEntity<>(updatedDto, HttpStatus.CREATED);
    }

    @PostMapping("/mess/searchByPr")
    public ResponseEntity<List<MessDto>> searchByPrice(@Valid @RequestBody SearchDto messDto) {
        List<MessDto> updatedDto = this.messService.searchByPrice(messDto);
        return new ResponseEntity<>(updatedDto, HttpStatus.CREATED);
    }

    @GetMapping("/mess/menu/{id}")
    public ResponseEntity<Object> getMenuById(@Valid @PathVariable Integer id) {
        return new ResponseEntity<>(this.messService.getMenuById(id), HttpStatus.OK);
    }

}
