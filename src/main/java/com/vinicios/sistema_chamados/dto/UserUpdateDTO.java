package com.vinicios.sistema_chamados.dto;

public record UserUpdateDTO(
        String name,
        String email,
        String password,
        String userRole
) {
}
