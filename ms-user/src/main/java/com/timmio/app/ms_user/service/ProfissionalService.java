package com.timmio.app.ms_user.service;


import com.timmio.app.ms_user.model.Profissional;
import com.timmio.app.ms_user.repository.ProfissionalRepository;
import com.timmio.app.ms_user.validator.ProfissionalValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfissionalService {

    private final ProfissionalRepository repository;
    private final ProfissionalValidator validator;

    public Profissional salvar(Profissional profissional) {
        validator.validarProfissionalExistente(profissional);
        return repository.save(profissional);
    }

    public Optional<Profissional> obterPorId(Integer id) {
        return repository.findById(id);
    }

    public void deletarPorId(Integer id) { repository.deleteById(id); }
}
