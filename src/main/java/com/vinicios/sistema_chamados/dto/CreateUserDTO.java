package com.vinicios.sistema_chamados.dto;

import jakarta.validation.constraints.NotBlank;

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

        //@NotBlank(message = "Departamento obrigatório!")
        UUID idDepartment
) {
}
