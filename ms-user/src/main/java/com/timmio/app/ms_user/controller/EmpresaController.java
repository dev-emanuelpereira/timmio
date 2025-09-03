package com.timmio.app.ms_user.controller;

import com.timmio.app.ms_user.controller.dto.EmpresaDTO;
import com.timmio.app.ms_user.controller.dto.ResultadoEmpresaPesquisa;
import com.timmio.app.ms_user.controller.dto.ResultadoProfissionalPesquisa;
import com.timmio.app.ms_user.controller.dto.ResultadoServicosEmpresaPesquisa;
import com.timmio.app.ms_user.controller.mapper.EmpresaMapper;
import com.timmio.app.ms_user.model.Empresa;
import com.timmio.app.ms_user.service.EmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("empresas")
public class EmpresaController implements GenericController {

    private final EmpresaService service;
    private final EmpresaMapper mapper;

    @PostMapping
    public ResponseEntity<Object> salvar (@RequestBody @Valid EmpresaDTO empresaDTO) {
        Empresa empresa = mapper.toEntity(empresaDTO);
        service.salvar(empresa);

        var location = gerarHeaderLocation(empresa.getIdEmpresa());

        return ResponseEntity.created(location).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoEmpresaPesquisa> obterDetalhes(@PathVariable("id") Integer id) {
        return service.obterPorId(id).map(
                empresa -> {
                    var dto = mapper.toDTO(empresa);
                    return ResponseEntity.ok(dto);
                }
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/servicos")
    public ResponseEntity<ResultadoServicosEmpresaPesquisa> obterDetalhesServicos(@PathVariable("id") Integer id) {
        return service.obterPorId(id).map(empresa -> {
                var dto = mapper.toServicosDTO(empresa);
                return ResponseEntity.ok(dto);
            }
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
