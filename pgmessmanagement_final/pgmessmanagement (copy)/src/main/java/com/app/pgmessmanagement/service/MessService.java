package com.app.pgmessmanagement.service;

import com.app.pgmessmanagement.dto.MessDto;
import com.app.pgmessmanagement.dto.SearchDto;

import java.util.List;

public interface MessService {
    MessDto addMess(MessDto messDto);

    MessDto updateMess(MessDto messDto);

    MessDto getMessById(Integer messDto);

    List<MessDto> getMessByuserId(Integer userId);

    List<MessDto> searchByLocation(SearchDto messDto);

    List<MessDto> searchByPrice(SearchDto messDto);

    List<MessDto> findAllMess();

    Object getMenuById(Integer id);
}
