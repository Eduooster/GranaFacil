package org.example.granafacil.core.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContaFinanceira{
    private Long id;
    private String pluggyAccountId;
    private ConexaoOpenFinance conexaoOpenFinance;
    private InstituicaoFinanceira instituicaoFinanceira;
    private String accountName;
    private String accountType;
    private String accountSubtype;
    private String moeda;
    private BigDecimal saldoAtual;
    private LocalDateTime dataUltimaAtt;
    private String apelido;

}
