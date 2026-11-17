package com.example.appcontaduria.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private Long id;
    private String username;
    private String name;
    private String password;
    private User.Rol rol;

    public enum Rol{
        ADMIN,
        REGULAR
    }

}
