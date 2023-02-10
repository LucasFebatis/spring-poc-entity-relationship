package com.febatis.demo.model.dto;

import com.febatis.demo.model.entity.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
public class SupplierRequestDTO {
    private String name;
    private List<UUID> productUuidList = new ArrayList<>();
}
