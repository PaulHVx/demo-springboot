package com.example.demo.infrastructure.adapter.out.persistence;

import com.example.demo.infrastructure.adapter.out.persistence.entity.UsuarioEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UsuarioReactiveRepository
        extends ReactiveCrudRepository<UsuarioEntity, Long> {

    Mono<UsuarioEntity> findByUsername(String username);
}
