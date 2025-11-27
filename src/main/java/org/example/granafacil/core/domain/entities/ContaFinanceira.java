package org.example.granafacil.core.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//representa a account vinculada ao item
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
