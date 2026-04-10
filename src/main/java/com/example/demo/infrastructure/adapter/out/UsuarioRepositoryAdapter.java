package com.example.demo.infrastructure.adapter.out;

import  com.example.demo.domain.model.Usuario;
import com.example.demo.application.ports.out.UsuarioRepositoryPort;
import com.example.demo.infrastructure.adapter.out.persistence.UsuarioReactiveRepository;
import com.example.demo.infrastructure.adapter.out.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioReactiveRepository repo;

    public UsuarioRepositoryAdapter(UsuarioReactiveRepository repo) {
        this.repo = repo;
    }

    @Override
    public Mono<Usuario> save(Usuario usuario) {
        return repo.save(toEntity(usuario)).map(this::toDomain);
    }

    @Override
    public Flux<Usuario> findAll() {
        return repo.findAll().map(this::toDomain);
    }

    @Override
    public Mono<Usuario> findById(Long id) {
        return repo.findById(id).map(this::toDomain);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return repo.deleteById(id);
    }

    @Override
    public Mono<Usuario> findByUsername(String username) {
        return repo.findByUsername(username).map(this::toDomain);
    }

    private Usuario toDomain(UsuarioEntity e) {
        Usuario u = new Usuario();
        u.setId(e.getId());
        u.setUsername(e.getUsername());
        u.setPassword(e.getPassword());
        return u;
    }

    private UsuarioEntity toEntity(Usuario u) {
        UsuarioEntity e = new UsuarioEntity();
        e.setId(u.getId());
        e.setUsername(u.getUsername());
        e.setPassword(u.getPassword());
        return e;
    }
}
