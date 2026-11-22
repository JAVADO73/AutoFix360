package com.example.appGestionPedidos.repository;

import com.example.appGestionPedidos.data.Pedido;
import org.springframework.data.repository.ListCrudRepository;

public interface PedidoRepository extends ListCrudRepository<Pedido, Long> { }
