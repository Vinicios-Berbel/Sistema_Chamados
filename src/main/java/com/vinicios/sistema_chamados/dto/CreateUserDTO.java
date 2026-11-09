package com.vinicios.sistema_chamados.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateUserDTO(
        @NotBlank(message = "Nome obrigatório!")
        String name,

        @NotBlank(message = "E-mail obrigatório!")
        String email,

        @NotBlank(message = "Senha obrigatório!")
        String password,

        @NotBlank(message = "Tipo de perfil obrigatório")
        String userRole,
        //@NotNull(message = "O departamento não pode ser nulo")
        //@NotBlank(message = "Departamento obrigatório!")
        UUID idDepartment
) {
}
