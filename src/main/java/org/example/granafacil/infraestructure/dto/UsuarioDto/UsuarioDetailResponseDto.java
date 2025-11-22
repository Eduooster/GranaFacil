package org.example.granafacil.infraestructure.dto.UsuarioDto;

import org.example.granafacil.core.enums.FormaGerenciarFinancas;
import org.example.granafacil.core.enums.ObjetivoFinanceiro;
import org.example.granafacil.core.enums.PerfilFinanceiro;

public record UsuarioDetailResponseDto(
        Long id,
        String nome, String sobrenome, String email, String senha,
        ObjetivoFinanceiro objetivo,
        FormaGerenciarFinancas financas,
        PerfilFinanceiro perfil
) {
}
