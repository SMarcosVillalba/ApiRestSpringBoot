package com.example.apirestspringbootfinal.services;

import com.example.apirestspringbootfinal.jpa.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductosRepository extends JpaRepository<Producto, String> {

    @Query("select p from Producto p where p.descripcion like ?1")
    public List<Producto> busquedaPorDescripcion(String filtro);

}
