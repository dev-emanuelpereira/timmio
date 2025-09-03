package com.timmio.app.ms_user.controller.dto;

import com.timmio.app.ms_user.model.RamoEmpresa;
import com.timmio.app.ms_user.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.List;

public record ResultadoEmpresaPesquisa(
        String nomeEmpresa,
        RamoEmpresa ramoEmpresa,
        String descricaoEmpresa,
        List<String> servicos,
        ResultadoUsuarioDTO usuario,
        LocalTime horarioInicio,
        LocalTime horarioTermino
) {
}
