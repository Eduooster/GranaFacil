package org.example.granafacil.core.domain.entities;

import org.example.granafacil.core.domain.enums.CategoriaTipo;
import org.example.granafacil.core.domain.enums.TipoTransacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transacao(
        Long id,
        String pluggyTransactionId,
        String descricao,
        BigDecimal valor,
        TipoTransacao tipoTransacao,
        LocalDateTime dataTransacao,
        LocalDateTime dataImportacao,
        String merchant,
        String providerName,
        String categoryPluggy,
        ContaFinanceira contaFinanceira,
        CategoriaTipo categoriaTipo,
        Usuario usuario
) {}

