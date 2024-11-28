package com.app.pgmessmanagement.service;

import com.app.pgmessmanagement.dto.MessDto;
import com.app.pgmessmanagement.dto.SearchDto;
import com.app.pgmessmanagement.exception.ResourceNotFoundException;
import com.app.pgmessmanagement.model.Menu;
import com.app.pgmessmanagement.model.Mess;
import com.app.pgmessmanagement.repository.MenuRepository;
import com.app.pgmessmanagement.repository.MessRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class MessServiceImpl implements MessService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MessRepository messRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public MessDto addMess(MessDto messDto) {
        Mess mess = messRepository.save(mapper.map(messDto, Mess.class));
        for(Menu m :mess.getMenuList()){
            m.setMessId(mess.getMessId());
        }
        return mapper.map(messRepository.save(mess), MessDto.class);
    }

    @Override
    public MessDto updateMess(MessDto messDto) {
        Mess mess = messRepository.findById(messDto.getMessId()).orElseThrow(() -> new ResourceNotFoundException("Invalid mess id"));
        mess.setMessName(messDto.getMessName());
        mess.setDescription(messDto.getDescription());
        mess.setImage(messDto.getImage());
        mess.setLocation(messDto.getLocation());
        mess.setPrice(messDto.getPrice());
        mess.setMenuList(messDto.getMenuList());
        return mapper.map(messRepository.save(mess),MessDto.class);
    }

    @Override
    public MessDto getMessById(Integer id) {
        Mess mess = messRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid mess id"));
        return mapper.map(mess,MessDto.class);
    }

    @Override
    public List<MessDto> getMessByuserId(Integer userId) {
        return  messRepository.findByUserId(userId).stream().map(m->mapper.map(m, MessDto.class)).toList();
    }

    @Override
    public List<MessDto> searchByLocation(SearchDto messDto) {
        if(messDto.getLocation().isBlank()){
            throw new ResourceNotFoundException("Location can not be empty");
        }
        return messRepository.findByLocation(messDto.getLocation()).stream().map(m -> mapper.map(m, MessDto.class)).toList();
    }

    @Override
    public List<MessDto> searchByPrice(SearchDto messDto) {
        if(messDto.getPrice() == null){
            throw new ResourceNotFoundException("Price can not be empty");
        }
        return messRepository.findByPrice(messDto.getPrice()).stream().map(m -> mapper.map(m,MessDto.class)).toList();
    }

    @Override
    public List<MessDto> findAllMess() {
        return messRepository.findAll().stream().map(m-> mapper.map(m, MessDto.class)).toList();
    }

    @Override
    public Object getMenuById(Integer id) {
        return menuRepository.findByMessId(id);
    }

}
