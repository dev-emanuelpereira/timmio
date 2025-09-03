package com.timmio.app.ms_user.controller.mapper;

import com.timmio.app.ms_user.controller.dto.EmpresaDTO;
import com.timmio.app.ms_user.controller.dto.ResultadoEmpresaPesquisa;
import com.timmio.app.ms_user.controller.dto.ResultadoServicosEmpresaPesquisa;
import com.timmio.app.ms_user.model.Empresa;
import com.timmio.app.ms_user.repository.UsuarioRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class EmpresaMapper {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Mapping(target = "usuario", expression = "java( usuarioRepository.findById(dto.idUsuario()).orElse(null) )")
    public abstract Empresa toEntity(EmpresaDTO dto);

    public abstract ResultadoEmpresaPesquisa toDTO(Empresa entity);

    public abstract ResultadoServicosEmpresaPesquisa toServicosDTO(Empresa entity);
}
