package com.example.appGestionPedidos.service;

import com.example.appGestionPedidos.data.Producto;
import com.example.appGestionPedidos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.lang.management.OperatingSystemMXBean;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<Producto> listar(){
        return productoRepository.findAll();
    }

    public Optional<Producto> crear(String nombre, String descripcion, BigDecimal precio){
        if (nombre == null || nombre.trim().isEmpty()){
            return Optional.empty();
        }
        if (precio == null || precio.compareTo(BigDecimal.ZERO) <= 0){
            return Optional.empty();
        }

        Producto nuevo = new Producto();
        nuevo.setNombre(nombre.trim());
        nuevo.setDescripcion(descripcion);
        nuevo.setPrecio(precio);
        nuevo.setDisponible(true);

        return Optional.of(productoRepository.save(nuevo));
    }
}
