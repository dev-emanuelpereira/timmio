package com.timmio.app.ms_user.controller;

import com.timmio.app.ms_user.controller.dto.ProfissionalDTO;
import com.timmio.app.ms_user.controller.dto.ResultadoProfissionalPesquisa;
import com.timmio.app.ms_user.controller.mapper.ProfissionalMapper;
import com.timmio.app.ms_user.model.Profissional;
import com.timmio.app.ms_user.service.ProfissionalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("profissionais")
public class ProfissionalController implements GenericController {

    private final ProfissionalService service;
    private final ProfissionalMapper mapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid ProfissionalDTO cadastroProfissionalDTO) {
        Profissional profissional = mapper.toEntity(cadastroProfissionalDTO);
        service.salvar(profissional);

        var location = gerarHeaderLocation(profissional.getIdProfissional());

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoProfissionalPesquisa> obterDetalhes(@PathVariable("id") Integer id) {
        return service.obterPorId(id).map(
                profissional -> {
                    var dto = mapper.toDTO(profissional);
                    return ResponseEntity.ok(dto);
                }
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId (@PathVariable("id") Integer id) {
        var profissionalEncontrado = service.obterPorId(id);
        if (profissionalEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(profissionalEncontrado.get());
        return ResponseEntity.ok().build();
    }
}
