package com.example.appGestionPedidos.data;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private BigDecimal total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<LineaPedido> lineas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="registrado_por")
    private User registradoPor;

    public enum Estado{
        NUEVO,
        EN_PREPARACION,
        ENTREGADO
    }


}

