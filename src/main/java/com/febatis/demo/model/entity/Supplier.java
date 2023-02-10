package com.febatis.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "listSupplier")
    @Column(nullable = false)
    private List<Product> productCatalog;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(List<Product> productCatalog) {
        this.productCatalog = productCatalog;
    }
}
