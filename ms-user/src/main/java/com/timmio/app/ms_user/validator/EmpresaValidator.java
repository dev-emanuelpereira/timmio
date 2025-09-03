package com.timmio.app.ms_user.validator;

import com.timmio.app.ms_user.exceptions.ProfissionalDuplicadoException;
import com.timmio.app.ms_user.model.Empresa;
import com.timmio.app.ms_user.model.Profissional;
import com.timmio.app.ms_user.repository.EmpresaRepository;
import com.timmio.app.ms_user.repository.ProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmpresaValidator {

    private final EmpresaRepository repository;

    public void validarEmpresaExistente(Empresa empresa) {
        if (existeEmpresaCadastrado(empresa)) {
            throw new ProfissionalDuplicadoException("Já existe uma empresa cadastrada com estes dados");
        }
    }

    private boolean existeEmpresaCadastrado(Empresa empresa) {
        Optional<Empresa> empresaEncontrada = repository.findByNomeEmpresa(empresa.getNomeEmpresa());

        if(empresa.getIdEmpresa() == null) {
            return empresaEncontrada.isPresent();
        }
        return !empresa.getIdEmpresa().equals(empresaEncontrada.get().getIdEmpresa()) && empresaEncontrada.isPresent();
    }
}
