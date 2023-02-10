package com.febatis.demo.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class ProductResponseDTO {
    private UUID uuid;
    private String name;
    private String description;
    private List<UUID> supplierUuidList;
}
