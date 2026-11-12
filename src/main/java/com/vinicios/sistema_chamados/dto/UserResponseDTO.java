package com.vinicios.sistema_chamados.dto;

import com.vinicios.sistema_chamados.model.UserRole;
import jakarta.validation.constraints.NotBlank;

public record UserResponseDTO(
        @NotBlank(message = "Identificador obrigatório")
        Long identifier,
        @NotBlank(message = "Nome obrigatório")
        String name,
        @NotBlank(message = "e-mail obrigatório")
        String email,
        @NotBlank(message = "Departamento obrigatório")
        String department,
        @NotBlank(message = "Tipo de usuário obrigatório")
        UserRole userRole
) {
}
