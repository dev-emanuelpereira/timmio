package com.timmio.app.ms_user.controller.dto;

import com.timmio.app.ms_user.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResultadoProfissionalPesquisa (
        Integer idProfissional,
        String nomeProfissional,
        String cpfProfissional,
        ResultadoUsuarioDTO usuario
) {
}
