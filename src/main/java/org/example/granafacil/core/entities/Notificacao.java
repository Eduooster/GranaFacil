package org.example.granafacil.core.entities;

import org.example.granafacil.core.enums.CategoriaTipo;
import org.example.granafacil.core.enums.StatusNotificacao;
import org.example.granafacil.core.enums.TipoNotificacao;

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

