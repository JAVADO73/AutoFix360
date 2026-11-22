package com.example.appGestionPedidos.repository;

import com.example.appGestionPedidos.data.Producto;
import org.springframework.data.repository.ListCrudRepository;



public interface ProductoRepository extends ListCrudRepository<Producto, Long> {

}
