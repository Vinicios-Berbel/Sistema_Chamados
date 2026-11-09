package com.vinicios.sistema_chamados.dto;

import com.vinicios.sistema_chamados.model.UserRole;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record ListUserDTO(
        Long identifier,

        @NotBlank(message = "Nome obrigatório!")
        String name,

        @NotBlank(message = "E-mail obrigatório!")
        String email,

        @NotBlank(message = "Tipo de perfil obrigatório")
        UserRole userRole,
        //@NotNull(message = "O departamento não pode ser nulo")
        //@NotBlank(message = "Departamento obrigatório!")
        UUID idDepartment
) {
}
