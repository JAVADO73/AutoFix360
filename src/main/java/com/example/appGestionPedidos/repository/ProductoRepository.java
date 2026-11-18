package com.example.appGestionPedidos.repository;

import com.example.appGestionPedidos.data.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository {
    Producto save(Producto producto);
    List<Producto> findAll(); //devuelve la lista completa
    Optional<Producto> findById(Long id); //para armar pedidos
}
