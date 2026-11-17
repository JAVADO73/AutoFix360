package com.example.appcontaduria.service;

import com.example.appcontaduria.data.User;
import com.example.appcontaduria.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    //tercera capa el userRepository
    private final UserRepository userRepository;

    //lo va a inyectar
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //buscar usuario por username
    public Optional<User>findByUsername(String username){
        if (username == null || username.trim().isEmpty()){
            return Optional.empty();
        }
        return userRepository.findByUsername(username.trim());
    }

    public Optional<User> registrar(String username, String name, String password){
        if (username == null || username.trim().isEmpty()){
            return Optional.empty();
        }
        String limpio = username.trim();

        if (userRepository.findByUsername(limpio).isPresent()){
            return Optional.empty();
        }

        User nuevo = new User();
        nuevo.setUsername(limpio);
        nuevo.setName(name);
        nuevo.setPassword(password);
        nuevo.setRol(User.Rol.REGULAR);

        //Devuelvo Optional ya que este metodo puedo fallar, al ya el username estar ocupado.
        return Optional.of(userRepository.save(nuevo));
    }

}
