package com.timmio.app.ms_user.service;

import com.timmio.app.ms_user.model.Empresa;
import com.timmio.app.ms_user.repository.EmpresaRepository;
import com.timmio.app.ms_user.validator.EmpresaValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository repository;
    private final EmpresaValidator validator;

    public Empresa salvar(Empresa empresa) {
        validator.validarEmpresaExistente(empresa);
        return repository.save(empresa);
    }

    public Optional<Empresa> obterPorId(Integer id) {
        return repository.findById(id);
    }
}
