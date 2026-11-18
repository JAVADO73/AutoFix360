package com.example.appGestionPedidos.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pedido {
    private Long id;
    private String cliente;
    private LocalDateTime fecha;
    private Pedido.Estado estado;
    private BigDecimal total;
    private List<LineaPedido> lineas;
    private User registradoPor;

    public enum Estado{
        NUEVO,
        EN_PREPARACION,
        ENTREGADO
    }


}

