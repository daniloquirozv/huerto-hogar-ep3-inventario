package com.huertohogar.inventario.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huertohogar.inventario.inventario.model.Inventario;
import com.huertohogar.inventario.inventario.repository.InventarioRepository;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> findAllInventarios() {
        return inventarioRepository.findAll();
    }

    public Inventario findByIdInventario(Integer idInventario){
        return inventarioRepository.findByIdInventario(idInventario);
    }
    
    public void deleteByIdInventario(Integer idInventario){
        inventarioRepository.deleteById(idInventario);
    }
}
