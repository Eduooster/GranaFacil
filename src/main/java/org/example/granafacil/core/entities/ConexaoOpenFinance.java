package org.example.granafacil.core.entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class ConexaoOpenFinance{

    private Long id;
    private String linkId;
    private String status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataExpiracaoToken;
    private LocalDateTime ultimoSync;
    private String acessToken;
    private UUID pluggyItemId;
    private InstituicaoFinanceira instituicaoFinanceira;
    private Usuario usuario;
}
