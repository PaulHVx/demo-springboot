package com.example.demo.application.ports.out;

import com.example.demo.domain.model.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioRepositoryPort {
    Mono<Usuario> save(Usuario usuario);
    Flux<Usuario> findAll();
    Mono<Usuario> findById(Long id);
    Mono<Void> deleteById(Long id);
    Mono<Usuario> findByUsername(String username);
}