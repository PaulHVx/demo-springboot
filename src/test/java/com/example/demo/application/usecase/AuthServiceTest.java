package com.example.demo.application.usecase;

import com.example.demo.application.ports.out.TokenService;
import com.example.demo.domain.model.Usuario;
import com.example.demo.application.ports.out.UsuarioRepositoryPort;
import com.example.demo.infrastructure.adapter.in.security.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UsuarioRepositoryPort repo;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private AuthService authService;

    @Test
    void loginOk() {
        Usuario usuario = new Usuario();
        usuario.setUsername("paul");
        usuario.setPassword("123");

        when(repo.findByUsername("paul"))
                .thenReturn(Mono.just(usuario));

        when(tokenService.generateToken("paul"))
                .thenReturn("token123");

        Mono<String> result = authService.login("paul", "123");

        StepVerifier.create(result)
                .expectNext("token123")
                .verifyComplete();
    }

    @Test
    void loginErrorCredencialesInvalidas() {

        when(repo.findByUsername("paul"))
                .thenReturn(Mono.empty());

        Mono<String> result = authService.login("paul", "123");

        StepVerifier.create(result)
                .expectError(RuntimeException.class)
                .verify();
    }
}
