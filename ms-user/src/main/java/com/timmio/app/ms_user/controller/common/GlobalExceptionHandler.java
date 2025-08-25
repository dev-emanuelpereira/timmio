package com.timmio.app.ms_user.controller.common;

import com.timmio.app.ms_user.controller.dto.ErroCampo;
import com.timmio.app.ms_user.controller.dto.ErroResposta;
import com.timmio.app.ms_user.exceptions.ClienteDuplicadoException;
import com.timmio.app.ms_user.exceptions.ProfissionalDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteDuplicadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handleClienteDuplicadoException (ClienteDuplicadoException e) {
        return ErroResposta.conflito(e.getMessage());
    }

    @ExceptionHandler(ProfissionalDuplicadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handleClienteDuplicadoException (ProfissionalDuplicadoException e) {
        return ErroResposta.conflito(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResposta handleMethodArgumentNotValidException (MethodArgumentNotValidException e) {
        List<FieldError> fieldErrorList = e.getFieldErrors();
        List<ErroCampo> erroCampos = fieldErrorList.stream()
                .map(
                        erroCampo -> new ErroCampo(erroCampo.getField(), erroCampo.getDefaultMessage())
                ).toList();
        return new ErroResposta(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", erroCampos);
    }
}
