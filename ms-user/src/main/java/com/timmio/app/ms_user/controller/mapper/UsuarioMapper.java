package com.timmio.app.ms_user.controller.mapper;

import com.timmio.app.ms_user.controller.dto.UsuarioDTO;
import com.timmio.app.ms_user.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity (UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO (Usuario Usuario);

}
