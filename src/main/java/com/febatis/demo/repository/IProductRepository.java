package com.febatis.demo.repository;

import com.febatis.demo.model.entity.Foo;
import com.febatis.demo.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface IProductRepository extends JpaRepository<Product, UUID> {

    Optional<Product> findByName(String name);

    @Query("SELECT f FROM Product f WHERE LOWER(f.name) = LOWER(:name)")
    Optional<Product> retrieveByName(@Param("name") String name);

}
