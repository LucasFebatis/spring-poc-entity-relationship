package com.febatis.demo.controllers;

import com.febatis.demo.model.dto.SupplierRequestDTO;
import com.febatis.demo.model.dto.SupplierResponseDTO;
import com.febatis.demo.model.entity.Supplier;
import com.febatis.demo.service.SupplierService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/supplier-controller")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @GetMapping()
    public List<SupplierResponseDTO> getAllSupplier(){
        return service.findAll();
    }

    @GetMapping("/find-by-name-automatically/{name}")
    public SupplierResponseDTO getAllSupplier(@PathParam("name") String name){
        return service.findByNameAutomatically(name);
    }

    @GetMapping("/find-by-name-manually/{name}")
    public SupplierResponseDTO findByNameManually(@PathParam("name") String name){
        return service.findByNameManually(name);
    }

    @PostMapping()
    public SupplierResponseDTO createSupplier(@RequestBody SupplierRequestDTO SupplierToCreate) {
        return service.createSupplier(SupplierToCreate);
    }
}