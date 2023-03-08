package com.example.apirestspringbootfinal.services;

import com.example.apirestspringbootfinal.jpa.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {


}
