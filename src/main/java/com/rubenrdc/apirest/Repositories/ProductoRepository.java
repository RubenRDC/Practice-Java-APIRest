package com.rubenrdc.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubenrdc.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

    
}
