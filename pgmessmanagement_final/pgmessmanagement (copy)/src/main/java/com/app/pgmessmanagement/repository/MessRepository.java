package com.app.pgmessmanagement.repository;

import com.app.pgmessmanagement.model.Mess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessRepository extends JpaRepository<Mess,Integer> {

    List<Mess> findByUserId(Integer id);
    List<Mess> findByLocation(String location);

    List<Mess> findByPrice(Integer price);
}
