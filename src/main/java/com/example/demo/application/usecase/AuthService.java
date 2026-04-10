package com.example.demo.application.usecase;

import com.example.demo.application.ports.in.AuthUseCase;
import com.example.demo.application.ports.out.TokenService;
import com.example.demo.application.ports.out.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthService implements AuthUseCase {
    private final UsuarioRepositoryPort repo;
    private final TokenService tokenService;

    public AuthService(UsuarioRepositoryPort repo, TokenService tokenService) {
        this.repo = repo;
        this.tokenService  = tokenService ;
    }

    @Override
    public Mono<String> login(String username, String password) {
        return repo.findByUsername(username)
                .filter(u -> u.getPassword().equals(password))
                .switchIfEmpty(Mono.error(new RuntimeException("Credenciales inválidas")))
                .map(u -> tokenService .generateToken(u.getUsername()));
    }
}
