package com.febatis.demo.repository;

import com.febatis.demo.model.entity.Foo;
import com.febatis.demo.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ISupplierRepository extends JpaRepository<Supplier, UUID> {

    Optional<Supplier> findByName(String name);

    @Query("SELECT f FROM Supplier f WHERE LOWER(f.name) = LOWER(:name)")
    Optional<Supplier> retrieveByName(@Param("name") String name);

}
