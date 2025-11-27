package org.example.granafacil.infraestructure.presentation.dto.UsuarioDto;

public record UsuarioCreateRequestDto(
        String nome, String sobrenome, String email, String senha,String confirmarSenha

) {
}
