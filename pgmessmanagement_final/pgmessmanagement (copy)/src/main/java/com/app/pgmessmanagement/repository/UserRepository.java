package com.app.pgmessmanagement.repository;

import com.app.pgmessmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);
    List<User> findByUserIdIn(List<Integer> userIds);
}
