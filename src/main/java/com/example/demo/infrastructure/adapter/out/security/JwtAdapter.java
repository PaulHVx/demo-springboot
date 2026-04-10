package com.example.demo.infrastructure.adapter.out.security;

import com.example.demo.application.ports.out.TokenService;
import com.example.demo.infrastructure.adapter.in.security.JwtUtil;
import org.springframework.stereotype.Component;

@Component
public class JwtAdapter implements TokenService {

    private final JwtUtil jwtUtil;

    public JwtAdapter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String generateToken(String username) {
        return jwtUtil.generateToken(username);
    }
}