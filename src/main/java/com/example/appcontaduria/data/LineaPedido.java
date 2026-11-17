package com.example.appcontaduria.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.function.BiFunction;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LineaPedido {
    private Long id;
    private Producto producto;
    private int cantidad;
    private BigDecimal precioUnitario;
}
