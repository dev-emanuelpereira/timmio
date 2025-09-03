package com.timmio.app.ms_user.validator;

import com.timmio.app.ms_user.exceptions.ProfissionalDuplicadoException;
import com.timmio.app.ms_user.model.Profissional;
import com.timmio.app.ms_user.repository.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProfissionalValidator {

    private final ProfissionalRepository repository;

    public void validarProfissionalExistente(Profissional profissional) {
        if (existeProfissionalCadastrado(profissional)) {
            throw new ProfissionalDuplicadoException("Já existe um profissional cadastrado com estes dados");
        }
    }

    private boolean existeProfissionalCadastrado(Profissional profissional) {
        Optional<Profissional> profissionalEncontrado = repository.findByNomeProfissional(
                profissional.getNomeProfissional()
        );

        if(profissional.getIdProfissional() == null) {
            return profissionalEncontrado.isPresent();
        }
        return !profissional.getIdProfissional().equals(profissionalEncontrado.get().getIdProfissional()) && profissionalEncontrado.isPresent();
    }

}
