package com.example.appGestionPedidos.repository;

import com.example.appGestionPedidos.data.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    //unico
    Optional<User> findByUsername(String userName);

    User save(User user);

}
