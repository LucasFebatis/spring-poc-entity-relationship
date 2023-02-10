package com.febatis.demo.controllers;

import com.febatis.demo.model.dto.ProductRequestDTO;
import com.febatis.demo.model.dto.ProductResponseDTO;
import com.febatis.demo.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/product-controller")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping()
    public List<ProductResponseDTO> getAllProduct(){
        return service.findAll();
    }

    @GetMapping("/find-by-name-automatically/{name}")
    public ProductResponseDTO getAllProduct(@PathParam("name") String name){
        return service.findByNameAutomatically(name);
    }

    @GetMapping("/find-by-name-manually/{name}")
    public ProductResponseDTO findByNameManually(@PathParam("name") String name){
        return service.findByNameManually(name);
    }

    @PostMapping()
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO ProductToCreate) {
        return service.createProduct(ProductToCreate);
    }
}