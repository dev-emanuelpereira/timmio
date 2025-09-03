package com.timmio.app.ms_user.controller.dto;

import java.util.List;

public record ResultadoServicosEmpresaPesquisa (
        String nomeEmpresa,
        List<String> servicos
        ) {
}
