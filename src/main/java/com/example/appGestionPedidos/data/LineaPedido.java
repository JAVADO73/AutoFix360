package com.example.appGestionPedidos.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="lineas_pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class LineaPedido {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Producto producto;
    private int cantidad;
    private BigDecimal precioUnitario;
}
