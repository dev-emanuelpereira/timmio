package com.timmio.app.ms_user.controller.mapper;

import com.timmio.app.ms_user.controller.dto.ProfissionalDTO;
import com.timmio.app.ms_user.controller.dto.ResultadoProfissionalPesquisa;
import com.timmio.app.ms_user.model.Profissional;
import com.timmio.app.ms_user.repository.UsuarioRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProfissionalMapper {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Mapping(target = "usuario", expression = "java( usuarioRepository.findById(dto.idUsuario()).orElse(null) )")
    public abstract Profissional toEntity(ProfissionalDTO dto);

    public abstract ResultadoProfissionalPesquisa toDTO(Profissional entity);
}
