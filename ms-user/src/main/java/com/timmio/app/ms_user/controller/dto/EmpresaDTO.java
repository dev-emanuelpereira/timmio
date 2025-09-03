package com.timmio.app.ms_user.controller.dto;

import com.timmio.app.ms_user.model.RamoEmpresa;
import com.timmio.app.ms_user.model.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalTime;
import java.util.List;

public record EmpresaDTO (
        @NotBlank
        String nomeEmpresa,
        @NotNull
        RamoEmpresa ramoEmpresa,
        String descricaoEmpresa,
        List<String> servicos,
        @NotNull
        Integer idUsuario,
        LocalTime horarioInicio,
        LocalTime horarioTermino
) {
}
