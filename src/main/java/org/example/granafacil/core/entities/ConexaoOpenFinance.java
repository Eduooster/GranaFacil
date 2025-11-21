package org.example.granafacil.core.entities;

import java.time.Instant;
import java.time.LocalDateTime;

public record ConexaoOpenFinance(
        Long id,
        String linkId,
        String status,
        LocalDateTime dataCriacao,
        LocalDateTime dataExpiracaoToken,
        LocalDateTime ultimoSync,
        String acessToken,
        InstituicaoFinanceira instituicaoFinanceira,
        Usuario usuario


) {
}
