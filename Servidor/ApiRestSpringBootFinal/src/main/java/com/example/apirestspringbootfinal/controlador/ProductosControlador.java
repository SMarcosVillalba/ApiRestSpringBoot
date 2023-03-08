package com.example.apirestspringbootfinal.controlador;

import com.example.apirestspringbootfinal.jpa.Producto;
import com.example.apirestspringbootfinal.services.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class ProductosControlador {
    @Autowired
    ProductosRepository productos;


    @GetMapping("/todos")
    public List<Producto> todos() {
        return productos.findAll();
    }


    @GetMapping("{desc}")
    public List<Producto> buscaProductos(@PathVariable("desc") String desc) {
        return productos.busquedaPorDescripcion("%"+desc+"%");
    }
}
