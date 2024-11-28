package com.app.pgmessmanagement.service;

import com.app.pgmessmanagement.dto.BookPgDto;
import com.app.pgmessmanagement.dto.BookedPgResponseDto;
import com.app.pgmessmanagement.dto.PgRequestDto;
import com.app.pgmessmanagement.dto.SearchDto;
import com.app.pgmessmanagement.exception.ResourceNotFoundException;
import com.app.pgmessmanagement.model.BookedPg;
import com.app.pgmessmanagement.model.Pg;
import com.app.pgmessmanagement.model.User;
import com.app.pgmessmanagement.repository.BookePgRepository;
import com.app.pgmessmanagement.repository.PgRepository;
import com.app.pgmessmanagement.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PgServiceImpl implements PgService{

    @Autowired
    private PgRepository pgRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookePgRepository bookePgRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public PgRequestDto addPg(PgRequestDto pgRequestDto) {
        return mapper.map(pgRepository.save(this.mapper.map(pgRequestDto, Pg.class)), PgRequestDto.class);
    }

    @Override
    public PgRequestDto updatePg(PgRequestDto pgRequestDto) {
        Pg pg = pgRepository.findById(pgRequestDto.getPgId()).orElseThrow(() -> new ResourceNotFoundException("Invalid Pg Id"));
        pg.setDescription(pgRequestDto.getDescription());
        pg.setLocation(pgRequestDto.getLocation());
        pg.setPrice(pgRequestDto.getPrice());
        pg.setRoomCount(pgRequestDto.getRoomCount());
        pg.setPgName(pgRequestDto.getPgName());
        pg.setImage(pgRequestDto.getImage());
        pg.setBookedCount(pg.getBookedCount());
        pg.setUserId(pgRequestDto.getUserId());
        if(pgRequestDto.getIsFull())
            pg.setIsFull(pgRequestDto.getIsFull());
        return mapper.map(pgRepository.save(pg),PgRequestDto.class);
    }

    @Override
    public void deletePgById(Integer pgId) {
        pgRepository.findById(pgId).orElseThrow(() -> new ResourceNotFoundException("Invalid Pg Id"));
        pgRepository.deleteById(pgId);
    }

    @Override
    public PgRequestDto getPgById(Integer pgId) {
        Pg pg = pgRepository.findById(pgId).orElseThrow(() -> new ResourceNotFoundException("Invalid Pg Id"));
        return mapper.map(pg,PgRequestDto.class);
    }

    @Override
    public List<PgRequestDto> getPgByuserId(Integer userId) {
        return pgRepository.findByUserId(userId).stream().map(m->mapper.map(m,PgRequestDto.class)).toList();
    }

    @Override
    public List<PgRequestDto> searchByLocation(SearchDto SearchDto) {
        if(SearchDto.getLocation().isBlank()){
            throw new ResourceNotFoundException("Location can not be empty");
        }
        return pgRepository.findByLocation(SearchDto.getLocation()).stream().map(m -> mapper.map(m, PgRequestDto.class)).toList();
    }

    @Override
    public List<PgRequestDto> searchByPrice(SearchDto searchDto) {
        if(searchDto.getPrice()==null){
            throw new ResourceNotFoundException("Price can not be empty");
        }
        return pgRepository.findByPrice(searchDto.getPrice()).stream().map(m -> mapper.map(m, PgRequestDto.class)).toList();
    }

    @Override
    public List<PgRequestDto> findAllPg() {
        return pgRepository.findAll().stream().map(m -> mapper.map(m, PgRequestDto.class)).toList();
    }

    @Override
    public Object bookPg(BookPgDto bookPgDto) {

        Pg pg = pgRepository.findById(bookPgDto.getPgId()).orElseThrow(() -> new ResourceNotFoundException("Invalid Pg Id"));
        if(pg.getIsFull()){
            return pg.getPgName()+" is full, Book once seat is vacent";
        }
        pg.setBookedCount(pg.getBookedCount()+1);
        if(pg.getRoomCount()== pg.getBookedCount()){
            pg.setIsFull(true);
        }
        pgRepository.save(pg);
        bookPgDto.setOwnerUserId(pg.getUserId());
        bookePgRepository.save(mapper.map(bookPgDto, BookedPg.class));
        return pg.getPgName()+" Pg Booked Successfully";
    }

    @Override
    public Object getBookedPg(BookPgDto bookPgDto) {
        List<BookedPg> bookedPg = bookePgRepository.findByPgId(bookPgDto.getPgId());
        if(bookedPg.isEmpty()){
            return "No Pg Rooms Booked Yet";
        }
        List<Integer> userIds = bookedPg.stream().map(m -> m.getUserId()).toList();
        Pg pg = pgRepository.findById(bookPgDto.getPgId()).orElseThrow(() -> new ResourceNotFoundException("Invalid Pg Id"));
        List<BookedPgResponseDto> response =  new ArrayList<>();
        for(Integer id : userIds){
            User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid user Id"));
            BookedPgResponseDto map = mapper.map(pg, BookedPgResponseDto.class);
            map.setBookedBy(user.getUserName());
            map.setContactNumber(user.getContactNumber());
            response.add(map);
        }
        return response;
    }


}
