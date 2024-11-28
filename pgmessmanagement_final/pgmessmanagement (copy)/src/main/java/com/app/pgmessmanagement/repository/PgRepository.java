package com.app.pgmessmanagement.repository;

import com.app.pgmessmanagement.model.Mess;
import com.app.pgmessmanagement.model.Pg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PgRepository extends JpaRepository<Pg,Integer> {

    List<Pg> findByUserId(Integer id);

    List<Pg> findByLocation(String location);

    List<Pg> findByPrice(Integer price);

}
