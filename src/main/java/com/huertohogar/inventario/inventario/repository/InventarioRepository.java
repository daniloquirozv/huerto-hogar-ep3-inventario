package com.huertohogar.inventario.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.huertohogar.inventario.inventario.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

    public Inventario findByIdInventario(Integer idInventario);

    @Query("SELECT SUM(i.stock) FROM Inventario i")
    Long getTotalStock();

}
