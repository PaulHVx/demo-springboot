package com.example.demo.infrastructure.adapter.in.mapper;

import com.example.demo.domain.model.Usuario;
import com.example.demo.infrastructure.adapter.in.dto.UsuarioRequest;
import com.example.demo.infrastructure.adapter.in.dto.UsuarioResponse;

public class UsuarioMapper {

    // Domain → Response
    public static UsuarioResponse toResponse(Usuario usuario) {
        UsuarioResponse res = new UsuarioResponse();
        res.setId(usuario.getId());
        res.setUsername(usuario.getUsername());
        return res;
    }

    // Request → Domain
    public static Usuario toDomain(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setUsername(request.getUsername());
        usuario.setPassword(request.getPassword());
        return usuario;
    }
}