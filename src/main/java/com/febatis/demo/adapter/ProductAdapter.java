package com.febatis.demo.adapter;

import com.febatis.demo.model.dto.ProductRequestDTO;
import com.febatis.demo.model.dto.ProductResponseDTO;
import com.febatis.demo.model.entity.Product;
import com.febatis.demo.model.entity.Supplier;

import java.util.UUID;
import java.util.stream.Collectors;

public class ProductAdapter {

    public static Product uuidToEntity(UUID uuid) {
        return Product.builder()
                .uuid(uuid)
                .build();
    }

    public static Product toEntity(ProductRequestDTO requestDTO) {
        return Product.builder()
                .name(requestDTO.getName())
                .description(requestDTO.getDescription())
                .listSupplier(requestDTO.getSupplierUuidList()
                        .stream()
                        .map(SupplierAdapter::uuidToEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public static ProductResponseDTO toResponse(Product entity) {
        return ProductResponseDTO.builder()
                .uuid(entity.getUuid())
                .name(entity.getName())
                .supplierUuidList(entity.getListSupplier()
                        .stream()
                        .map(Supplier::getUuid)
                        .collect(Collectors.toList()))
                .build();
    }
}
