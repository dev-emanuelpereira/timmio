package com.timmio.app.ms_user.controller.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record UsuarioDTO (
        Integer idUsuario,
        @NotBlank(message = "Campo obrigatório")
        String nomeUsuario,
        @NotBlank(message = "Campo obrigatório")
        @CPF
        String cpfCliente,
        @NotNull(message = "Campo obrigatório")
        String dddCliente,
        @NotNull(message = "Campo obrigatório")
        String telefoneCliente,
        List<ProfissionalDTO> profissionais
){

}
