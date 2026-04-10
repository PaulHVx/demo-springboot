package com.example.demo.infrastructure.adapter.in.controller;

import com.example.demo.application.ports.in.AuthUseCase;
import com.example.demo.infrastructure.adapter.in.dto.LoginRequest;
import com.example.demo.infrastructure.adapter.in.dto.LoginResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthUseCase authUseCase;

    public AuthController(AuthUseCase authUseCase) {
        this.authUseCase = authUseCase;
    }

    @PostMapping("/login")
    public Mono<LoginResponse> login(@RequestBody LoginRequest request) {

        return authUseCase.login(request.getUsername(), request.getPassword())
                .map(LoginResponse::new);
    }
}
