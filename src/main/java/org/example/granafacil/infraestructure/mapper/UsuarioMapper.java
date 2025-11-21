package org.example.granafacil.infraestructure.mapper;


import org.example.granafacil.core.entities.Usuario;
import org.example.granafacil.infraestructure.dto.UsuarioDto.UsuarioDetailResponseDto;
import org.example.granafacil.infraestructure.gateways.persistence.entites.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(
        componentModel = "spring"
)
public interface UsuarioMapper {



//    UsuarioEntity toEntity(Usuario usuario);
//
//
//    Usuario toDomain(UsuarioEntity usuarioEntity);
//
//
//    UsuarioDetailResponseDto toUsuarioDetailResponseDto(Usuario cadastroNovoUsuario);


}
