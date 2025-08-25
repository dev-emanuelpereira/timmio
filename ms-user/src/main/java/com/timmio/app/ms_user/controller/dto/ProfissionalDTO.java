package com.timmio.app.ms_user.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfissionalDTO(
        @NotNull
        Integer idUsuario,
        @NotBlank
        String nomeProfissional,
        @NotBlank
        String cpfProfissional
) {
}
