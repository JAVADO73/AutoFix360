package com.example.appGestionPedidos.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="productos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private boolean disponible;

}
