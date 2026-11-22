package com.example.appGestionPedidos.data;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_name", unique=true)
    private String username;

    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public enum Rol{
        ADMIN,
        REGULAR
    }

}
