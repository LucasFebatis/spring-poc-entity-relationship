package com.febatis.demo.repository;

import com.febatis.demo.model.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface IFooRepository extends JpaRepository<Foo, UUID> {

    Optional<Foo> findByName(String name);

    @Query("SELECT f FROM Foo f WHERE LOWER(f.name) = LOWER(:name)")
    Optional<Foo> retrieveByName(@Param("name") String name);

}
