package org.example.granafacil.core.entities;

import org.example.granafacil.core.enums.CategoriaTipo;
import org.example.granafacil.core.enums.StatusEstado;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MetaFinanceira(
        Long id,
        Usuario usuario,
        String descricao,
        BigDecimal valorObjetivo,
        BigDecimal valorAtual,
        CategoriaTipo categoriaTipo,
        LocalDateTime dataCriacao,
        LocalDateTime dataLimite,
        StatusEstado status
) {}

