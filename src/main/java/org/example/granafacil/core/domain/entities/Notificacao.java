package org.example.granafacil.core.domain.entities;

import org.example.granafacil.core.domain.enums.CategoriaTipo;
import org.example.granafacil.core.domain.enums.StatusNotificacao;
import org.example.granafacil.core.domain.enums.TipoNotificacao;

import java.time.LocalDateTime;

public record Notificacao(
        Long id,

        TipoNotificacao tipoNotificacao,

        String titulo,
        String mensagem,

        StatusNotificacao status,

        LocalDateTime dataEnvio,
        LocalDateTime dataLeitura,

        Usuario usuario,

        Transacao transacao,
        CategoriaTipo categoriaTipo,
        MetaFinanceira metaFinanceira
) {}

