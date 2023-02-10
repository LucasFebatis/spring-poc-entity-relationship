package com.febatis.demo.controllers;

import com.febatis.demo.model.dto.FooRequestDTO;
import com.febatis.demo.model.dto.FooResponseDTO;
import com.febatis.demo.service.FooService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/foo-controller")
public class FooController {

    @Autowired
    private FooService service;

    @GetMapping()
    public List<FooResponseDTO> getAllFoo(){
        return service.findAll();
    }

    @GetMapping("/find-by-name-automatically/{name}")
    public FooResponseDTO getAllFoo(@PathParam("name") String name){
        return service.findByNameAutomatically(name);
    }

    @GetMapping("/find-by-name-manually/{name}")
    public FooResponseDTO findByNameManually(@PathParam("name") String name){
        return service.findByNameManually(name);
    }

    @PostMapping()
    public FooResponseDTO createFoo(@RequestBody FooRequestDTO fooToCreate) {
        return service.createFoo(fooToCreate);
    }
}