package com.febatis.demo.adapter;

import com.febatis.demo.model.dto.SupplierRequestDTO;
import com.febatis.demo.model.dto.SupplierResponseDTO;
import com.febatis.demo.model.entity.Product;
import com.febatis.demo.model.entity.Supplier;

import java.util.UUID;
import java.util.stream.Collectors;

public class SupplierAdapter {

    public static Supplier uuidToEntity(UUID uuid) {
        return Supplier.builder()
                .uuid(uuid)
                .build();
    }

    public static Supplier toEntity(SupplierRequestDTO requestDTO) {
        return Supplier.builder()
                .name(requestDTO.getName())
                .productCatalog(requestDTO.getProductUuidList()
                        .stream()
                        .map(ProductAdapter::uuidToEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public static SupplierResponseDTO toResponse(Supplier entity) {
        return SupplierResponseDTO.builder()
                .uuid(entity.getUuid())
                .name(entity.getName())
                .productCatalog(entity.getProductCatalog()
                        .stream()
                        .map(Product::getUuid)
                        .collect(Collectors.toList()))
                .build();
    }
}
