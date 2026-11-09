package com.vinicios.sistema_chamados.dto;

import java.util.UUID;

public record CreateTicketDTO(
        String tittle,
        String description,
        UUID userId
) {}
