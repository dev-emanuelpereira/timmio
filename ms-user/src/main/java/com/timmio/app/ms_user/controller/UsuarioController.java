package com.timmio.app.ms_user.controller;

import com.timmio.app.ms_user.controller.dto.UsuarioDTO;
import com.timmio.app.ms_user.controller.mapper.UsuarioMapper;
import com.timmio.app.ms_user.model.Usuario;
import com.timmio.app.ms_user.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController implements GenericController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @PostMapping
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {

        Usuario usuario = mapper.toEntity(usuarioDTO);
        service.salvarUsuario(usuario);

        var location = gerarHeaderLocation(usuario.getIdUsuario());

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> visualizarUsuario(@PathVariable Integer id) {
        return service.obterPorId(id)
                .map(
                usuario -> {
                    UsuarioDTO dto = mapper.toDTO(usuario);
                    return ResponseEntity.ok(dto);
                }
                ).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
