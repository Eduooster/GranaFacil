package org.example.granafacil.core.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ContaFinanceira(
        Long id,
        String pluggyAccountId,
        ConexaoOpenFinance conexaoOpenFinance,
        InstituicaoFinanceira instituicaoFinanceira,
        String accountName,
        String accountType,
        String accountSubtype,
        String moeda,
        BigDecimal saldoAtual,
        LocalDateTime dataUltimaAtt,
        String apelido
) {}
