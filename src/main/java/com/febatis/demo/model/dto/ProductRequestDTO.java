package com.febatis.demo.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
public class ProductRequestDTO {
    private String name;
    private String description;
    private List<UUID> supplierUuidList = new ArrayList<>();
}
