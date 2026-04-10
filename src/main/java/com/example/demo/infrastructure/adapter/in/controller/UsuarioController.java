package com.example.demo.infrastructure.adapter.in.controller;

import com.example.demo.application.ports.in.UsuarioUseCase;
import com.example.demo.infrastructure.adapter.in.dto.UsuarioRequest;
import com.example.demo.infrastructure.adapter.in.dto.UsuarioResponse;
import com.example.demo.infrastructure.adapter.in.mapper.UsuarioMapper;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioUseCase service;

    public UsuarioController(UsuarioUseCase service) {
        this.service = service;
    }

    @GetMapping
    public Flux<UsuarioResponse> listar() {
        return service.listar()
                .map(UsuarioMapper::toResponse);
    }

    @GetMapping("/{id}")
    public Mono<UsuarioResponse> obtener(@PathVariable Long id) {
        return service.obtener(id)
                .map(UsuarioMapper::toResponse);
    }

    @PostMapping
    public Mono<UsuarioResponse> crear(@RequestBody UsuarioRequest usuario) {
        return service.crear(UsuarioMapper.toDomain(usuario))
                .map(UsuarioMapper::toResponse);
    }

    @PutMapping("/{id}")
    public Mono<UsuarioResponse> actualizar(@PathVariable Long id,
                              @RequestBody UsuarioRequest usuario) {
        return service.actualizar(id, UsuarioMapper.toDomain(usuario))
                .map(UsuarioMapper::toResponse);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable Long id) {
        return service.eliminar(id);
    }
}