package com.example.appGestionPedidos.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LineaPedido {
    private Long id;
    private Producto producto;
    private int cantidad;
    private BigDecimal precioUnitario;
}
