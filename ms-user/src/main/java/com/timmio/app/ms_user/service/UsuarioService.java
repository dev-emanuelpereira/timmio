package com.timmio.app.ms_user.service;

import com.timmio.app.ms_user.exceptions.OperacaoNaoPermitidaException;
import com.timmio.app.ms_user.model.Profissional;
import com.timmio.app.ms_user.model.Usuario;
import com.timmio.app.ms_user.repository.ProfissionalRepository;
import com.timmio.app.ms_user.repository.UsuarioRepository;
import com.timmio.app.ms_user.validator.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioValidator validator;
    private final ProfissionalRepository profissionalRepository;

    public Usuario salvarUsuario (Usuario usuario)  {
        validator.validarUsuarioExistente(usuario);
        return repository.save(usuario);
    }

    public Optional<Usuario> obterPorId (Integer id) {
        return repository.findById(id);
    }

    public void deletarUsuario (Usuario usuario) {
            if (possuiProfissional(usuario)) {
                throw new OperacaoNaoPermitidaException("Não é permitido deletar um usuário que possui profissionais.");
            }
        repository.delete(usuario);
    }

    private boolean possuiProfissional(Usuario usuario) {
        return profissionalRepository.existsByUsuario(usuario);
    }
}
