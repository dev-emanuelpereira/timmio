package com.timmio.app.ms_user.service;

import com.timmio.app.ms_user.model.Usuario;
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

    public Usuario salvarUsuario (Usuario usuario)  {
        validator.validarUsuarioExistente(usuario);
        return repository.save(usuario);
    }

    public Optional<Usuario> obterPorId (Integer id) {
        return repository.findById(id);
    }
}
