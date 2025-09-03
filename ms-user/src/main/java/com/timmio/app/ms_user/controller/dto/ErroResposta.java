package com.timmio.app.ms_user.controller.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResposta (Integer status, String mensage, List<ErroCampo> erros) {

    public static ErroResposta conflito(String mensagem) {
        return new ErroResposta(HttpStatus.CONFLICT.value(), mensagem, List.of());
    }

    public static ErroResposta naoEncontrado(String mensagem) {
        return new ErroResposta(HttpStatus.NOT_FOUND.value(), mensagem, List.of());
    }
}
