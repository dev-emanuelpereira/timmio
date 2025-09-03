package com.timmio.app.ms_user.validator;

import com.timmio.app.ms_user.exceptions.ClienteDuplicadoException;
import com.timmio.app.ms_user.model.Usuario;
import com.timmio.app.ms_user.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioValidator {

    private final UsuarioRepository repository;

    public void validarUsuarioExistente(Usuario usuario) {
        if (existeUsuarioCadastrado(usuario)) {
            throw new ClienteDuplicadoException("CPF CLIENTE JA EXISTE");
        }
    }

    private boolean existeUsuarioCadastrado(Usuario usuario) {
        Optional<Usuario> usuarioOptional = repository.findByCpfCliente(usuario.getCpfCliente());

        if (usuario.getIdUsuario() == null) {
            return usuarioOptional.isPresent();
        }

        return !usuario.getIdUsuario().equals(usuarioOptional.get().getIdUsuario()) && usuarioOptional.isPresent();
    }
}
