package com.febatis.demo.service;

import com.febatis.demo.adapter.FooAdapter;
import com.febatis.demo.model.dto.FooRequestDTO;
import com.febatis.demo.model.dto.FooResponseDTO;
import com.febatis.demo.repository.IFooRepository;
import com.febatis.demo.model.entity.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FooService {

    @Autowired
    private IFooRepository repository;

    public List<FooResponseDTO> findAll() {
        List<Foo> fooList = repository.findAll();
        return  fooList.stream().map(FooAdapter::toResponse).collect(Collectors.toList());
    }

    public FooResponseDTO findByNameAutomatically(String name) {
        Optional<Foo> foo = repository.findByName(name);
        return foo.map(FooAdapter::toResponse).orElse(null);
    }

    public FooResponseDTO findByNameManually(String name) {
        Optional<Foo> foo = repository.retrieveByName(name);
        return foo.map(FooAdapter::toResponse).orElse(null);
    }

    public FooResponseDTO createFoo(FooRequestDTO request) {
        Foo fooToCreate = FooAdapter.toEntity(request);
        Foo foo = repository.save(fooToCreate);
        return FooAdapter.toResponse(foo);
    }
}
