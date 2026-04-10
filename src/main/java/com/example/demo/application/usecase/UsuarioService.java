package com.example.demo.application.usecase;

import com.example.demo.domain.model.Usuario;
import com.example.demo.application.ports.in.UsuarioUseCase;
import com.example.demo.application.ports.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService implements UsuarioUseCase {
    private final UsuarioRepositoryPort repository;

    public UsuarioService(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Usuario> crear(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Flux<Usuario> listar() {
        return repository.findAll();
    }

    @Override
    public Mono<Usuario> obtener(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Usuario> actualizar(Long id, Usuario usuario) {
        usuario.setId(id);
        return repository.save(usuario);
    }

    @Override
    public Mono<Void> eliminar(Long id) {
        return repository.deleteById(id);
    }
}
