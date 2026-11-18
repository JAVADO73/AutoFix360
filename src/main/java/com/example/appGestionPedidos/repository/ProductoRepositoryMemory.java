package com.example.appGestionPedidos.repository;

import com.example.appGestionPedidos.data.Producto;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class ProductoRepositoryMemory implements  ProductoRepository {

    private final Map<Long, Producto> productos = new HashMap<>();
    private long siguienteId = 1;

    public ProductoRepositoryMemory(){
        Producto product = new Producto();
        product.setNombre("JFO0210");
        product.setDescripcion("Filtro Aceite");
        product.setPrecio(BigDecimal.valueOf(900.00));
        product.setDisponible(true);
    }

    @Override
    public Producto save(Producto producto){
        if (producto.getId()==null){
            producto.setId(siguienteId++);
        }
        productos.put(producto.getId(), producto);
        return producto;
    }

    @Override
    public List<Producto> findAll(){
        return new ArrayList<>(productos.values()); // no se usa values() ya que esta devuelce una vista viva del mapa, se modificaria nuestro mapa

    }

    @Override
    public Optional<Producto> findById(Long id){
        return Optional.ofNullable(productos.get(id));
    }
}
