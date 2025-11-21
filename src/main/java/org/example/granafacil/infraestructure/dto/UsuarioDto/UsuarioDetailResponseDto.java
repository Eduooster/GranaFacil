package org.example.granafacil.infraestructure.dto.UsuarioDto;

import org.example.granafacil.core.enums.FormaGerenciarFinancas;
import org.example.granafacil.core.enums.ObjetivoPrincipal;
import org.example.granafacil.core.enums.PerfilFinanceiro;

public record UsuarioDetailResponseDto(
        Long id,
        String nome, String sobrenome, String email, String senha,
        ObjetivoPrincipal objetivo,
        FormaGerenciarFinancas financas,
        PerfilFinanceiro perfil
) {
}
