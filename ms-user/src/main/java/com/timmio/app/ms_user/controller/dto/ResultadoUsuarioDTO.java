package com.timmio.app.ms_user.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record ResultadoUsuarioDTO (
        Integer idUsuario,
        String nomeUsuario,
        String cpfCliente,
        String dddCliente,
        String telefoneCliente
) {
}
