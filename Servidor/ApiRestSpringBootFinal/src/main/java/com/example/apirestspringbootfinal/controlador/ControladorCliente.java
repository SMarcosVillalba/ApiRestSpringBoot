package com.example.apirestspringbootfinal.controlador;

import com.example.apirestspringbootfinal.jpa.Cliente;
import com.example.apirestspringbootfinal.services.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ControladorCliente{
    @Autowired
    ClienteRepository clientes;

    @GetMapping("/todos")
    public List<Cliente> todos() {
        return clientes.findAll();
    }

    @GetMapping("{nif}")
    public Cliente unCliente(@PathVariable("nif") String nif) {
        return clientes.findById(nif).get();
    }

    @PostMapping("/nuevo")
    public Cliente nuevoCliente(@RequestBody Cliente c) {
        clientes.save(c);
        return c;
    }

    @PutMapping("/modificar")
    public Cliente modificarCliente(@RequestBody Cliente c) {
        clientes.save(c);
        return c;
    }

    @DeleteMapping("/eliminar/{nif}")
    public String borrarCliente(@PathVariable("nif") String nif) {
        clientes.deleteById(nif);
        return "Cliente "+nif+ " eliminado";
    }


}

