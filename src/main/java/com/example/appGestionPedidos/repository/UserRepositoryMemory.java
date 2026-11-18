package com.example.appGestionPedidos.repository;

import com.example.appGestionPedidos.data.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryMemory implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    public UserRepositoryMemory() {
        User admin = new User();
        admin.setUsername("sanjx");
        admin.setName("Santiago");
        admin.setPassword("123");
        admin.setRol(User.Rol.ADMIN);

        save(admin);

    }

    private long siguienteId=1;

    @Override
    public User save(User user){
        if (user.getId()== null){
            user.setId(siguienteId++);
        }
        users.put(user.getUsername(),user);
        return user;
    }


    @Override
    public Optional<User> findByUsername(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(users.get(userName));
    }
}
