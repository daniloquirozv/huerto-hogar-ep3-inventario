package com.huertohogar.inventario.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huertohogar.inventario.inventario.model.Inventario;
import com.huertohogar.inventario.inventario.service.InventarioService;

@RestController
@RequestMapping("api/v1/huertohogar/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<Inventario>> getAllInventario(){
        List<Inventario> inventario = inventarioService.findAllInventarios();
        if(inventario.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(inventario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable Integer id){
        try {
            Inventario inventario = inventarioService.findByIdInventario(id);
            return ResponseEntity.ok(inventario);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @DeleteMapping("/{id}")
    void deleteInventarioById(@PathVariable Integer id){
        inventarioService.deleteByIdInventario(id);
    }



}
