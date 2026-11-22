package com.example.appGestionPedidos.repository;

import com.example.appGestionPedidos.data.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Long> {
    Optional<User>findByUsername(String username);
}