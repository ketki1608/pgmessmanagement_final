package com.app.pgmessmanagement.service;

import com.app.pgmessmanagement.dto.BookPgDto;
import com.app.pgmessmanagement.dto.PgRequestDto;
import com.app.pgmessmanagement.dto.SearchDto;

import java.util.List;

public interface PgService {
    PgRequestDto addPg(PgRequestDto pgRequestDto);

    PgRequestDto updatePg(PgRequestDto pgRequestDto);

    void deletePgById(Integer pgId);

    PgRequestDto getPgById(Integer pgId);

    List<PgRequestDto> getPgByuserId(Integer userId);

    List<PgRequestDto> searchByLocation(SearchDto searchDto);

    List<PgRequestDto> searchByPrice(SearchDto searchDto);

    List<PgRequestDto> findAllPg();

    Object bookPg(BookPgDto bookPgDto);

    Object getBookedPg(BookPgDto bookPgDto);
}
