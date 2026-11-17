package com.example.appcontaduria.repository;

import com.example.appcontaduria.data.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    //unico
    Optional<User> findByUsername(String userName);

    User save(User user);

}
