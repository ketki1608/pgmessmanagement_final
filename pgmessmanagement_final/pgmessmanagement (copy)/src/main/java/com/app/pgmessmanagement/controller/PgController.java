package com.app.pgmessmanagement.controller;

import com.app.pgmessmanagement.dto.*;
import com.app.pgmessmanagement.service.PgService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PgController {

    @Autowired
    private PgService pgService;

    @PostMapping("/pg/addPg")
    public ResponseEntity<PgRequestDto> addPg(@Valid @RequestBody PgRequestDto pgRequestDto) {
        PgRequestDto createdpgDto = this.pgService.addPg(pgRequestDto);
        return new ResponseEntity<>(createdpgDto, HttpStatus.CREATED);
    }

    @PostMapping("/pg/updatePg")
    public ResponseEntity<PgRequestDto> updatePg(@Valid @RequestBody PgRequestDto pgRequestDto) {
        PgRequestDto createdpgDto = this.pgService.updatePg(pgRequestDto);
        return new ResponseEntity<>(createdpgDto, HttpStatus.OK);
    }

    @DeleteMapping("/pg/{id}")
    public ResponseEntity<?> deletePgById(@PathVariable String id) {
        this.pgService.deletePgById(Integer.valueOf(id));
        return new ResponseEntity<>("Pg deleted successfully of id : " + id, HttpStatus.OK);

    }

    @GetMapping("/pg/{id}")
    public ResponseEntity<?> getPgById(@PathVariable String id) {
        return new ResponseEntity<>(this.pgService.getPgById(Integer.valueOf(id)), HttpStatus.OK);

    }

    @GetMapping("/pg/findAll")
    public ResponseEntity<?> findAllPg() {
        return new ResponseEntity<>(this.pgService.findAllPg(), HttpStatus.OK);

    }

    @GetMapping("/pg/user/{userId}")
    public ResponseEntity<List<PgRequestDto>> getPgByuserId(@Valid @PathVariable Integer userId) {
        List<PgRequestDto> updatedDto = this.pgService.getPgByuserId(userId);
        return new ResponseEntity<>(updatedDto, HttpStatus.CREATED);
    }

    @PostMapping("/pg/searchByLoc")
    public ResponseEntity<List<PgRequestDto>> searchByLocation(@Valid @RequestBody SearchDto searchDto) {
        List<PgRequestDto> updatedDto = this.pgService.searchByLocation(searchDto);
        return new ResponseEntity<>(updatedDto, HttpStatus.CREATED);
    }

    @PostMapping("/pg/searchByPr")
    public ResponseEntity<List<PgRequestDto>> searchByPrice(@Valid @RequestBody SearchDto searchDto) {
        List<PgRequestDto> updatedDto = this.pgService.searchByPrice(searchDto);
        return new ResponseEntity<>(updatedDto, HttpStatus.CREATED);
    }

    @PostMapping("/pg/bookPg")
    public ResponseEntity<?> bookPg(@Valid @RequestBody BookPgDto bookPgDto) {
        return new ResponseEntity<>(this.pgService.bookPg(bookPgDto), HttpStatus.CREATED);
    }

    @GetMapping("/pg/fetchBookPg")
    public ResponseEntity<?> getBookedPg(@Valid @RequestBody BookPgDto bookPgDto) {
        return new ResponseEntity<>(this.pgService.getBookedPg(bookPgDto), HttpStatus.CREATED);
    }
}
