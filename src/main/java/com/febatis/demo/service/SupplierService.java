package com.febatis.demo.service;

import com.febatis.demo.adapter.SupplierAdapter;
import com.febatis.demo.model.dto.SupplierRequestDTO;
import com.febatis.demo.model.dto.SupplierResponseDTO;
import com.febatis.demo.model.entity.Supplier;
import com.febatis.demo.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private ISupplierRepository repository;

    public List<SupplierResponseDTO> findAll() {
        List<Supplier> productList = repository.findAll();
        return  productList.stream().map(SupplierAdapter::toResponse).collect(Collectors.toList());
    }

    public SupplierResponseDTO findByNameAutomatically(String name) {
        Optional<Supplier> supplier = repository.findByName(name);
        return supplier.map(SupplierAdapter::toResponse).orElse(null);
    }

    public SupplierResponseDTO findByNameManually(String name) {
        Optional<Supplier> supplier = repository.retrieveByName(name);
        return supplier.map(SupplierAdapter::toResponse).orElse(null);
    }

    public SupplierResponseDTO createSupplier(SupplierRequestDTO request) {
        Supplier supplierToCreate = SupplierAdapter.toEntity(request);
        Supplier supplierCreated = repository.save(supplierToCreate);
        return SupplierAdapter.toResponse(supplierCreated);
    }


    //    TODO: Add product
}
