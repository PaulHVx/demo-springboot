package com.example.demo.application.ports.in;

import reactor.core.publisher.Mono;

public interface AuthUseCase {
    Mono<String> login(String username, String password);
}
