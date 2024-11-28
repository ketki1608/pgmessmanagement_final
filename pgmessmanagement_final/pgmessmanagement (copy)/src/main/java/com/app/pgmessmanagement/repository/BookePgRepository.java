package com.app.pgmessmanagement.repository;

import com.app.pgmessmanagement.model.BookedPg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookePgRepository extends JpaRepository<BookedPg, Integer> {
    BookedPg findByUserId(Integer userId);
    List<BookedPg> findByPgId(Integer pgId);

}
