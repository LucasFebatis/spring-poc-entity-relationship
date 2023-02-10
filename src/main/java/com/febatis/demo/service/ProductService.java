package com.febatis.demo.service;

import com.febatis.demo.adapter.FooAdapter;
import com.febatis.demo.adapter.ProductAdapter;
import com.febatis.demo.model.dto.ProductRequestDTO;
import com.febatis.demo.model.dto.ProductResponseDTO;
import com.febatis.demo.model.entity.Foo;
import com.febatis.demo.model.entity.Product;
import com.febatis.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private IProductRepository repository;

    public List<ProductResponseDTO> findAll() {
        List<Product> productList = repository.findAll();
        return  productList.stream().map(ProductAdapter::toResponse).collect(Collectors.toList());
    }

    public ProductResponseDTO findByNameAutomatically(String name) {
        Optional<Product> foo = repository.findByName(name);
        return foo.map(ProductAdapter::toResponse).orElse(null);
    }

    public ProductResponseDTO findByNameManually(String name) {
        Optional<Product> foo = repository.retrieveByName(name);
        return foo.map(ProductAdapter::toResponse).orElse(null);
    }

    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        Product productToCreate = ProductAdapter.toEntity(request);
        Product productCreated = repository.save(productToCreate);
        return ProductAdapter.toResponse(productCreated);
    }

//    TODO: Add supplier

}
