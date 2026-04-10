package com.example.demo.application.ports.in;

import com.example.demo.domain.model.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UsuarioUseCase {
    Mono<Usuario> crear(Usuario usuario);
    Flux<Usuario> listar();
    Mono<Usuario> obtener(Long id);
    Mono<Usuario> actualizar(Long id, Usuario usuario);
    Mono<Void> eliminar(Long id);
}
