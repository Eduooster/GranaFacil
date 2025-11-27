package org.example.granafacil.infraestructure.persistence.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity


public class ContaFinanceiraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pluggyAccountId;

    @ManyToOne(fetch = FetchType.LAZY)
    private ConexaoOpenFinanceEntity conexaoOpenFinance;

    private String accountName;
    private String accountType;
    private String accountSubtype;
    private String moeda;
    private BigDecimal saldoAtual;
    private LocalDateTime dataUltimaAtt;
    private String apelido;

    @Override
    public String toString() {
        return "ContaFinanceiraEntity{" +
                "id=" + id +
                ", pluggyAccountId='" + pluggyAccountId + '\'' +
                ", conexaoOpenFinance=" + conexaoOpenFinance +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountSubtype='" + accountSubtype + '\'' +
                ", moeda='" + moeda + '\'' +
                ", saldoAtual=" + saldoAtual +
                ", dataUltimaAtt=" + dataUltimaAtt +
                ", apelido='" + apelido + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPluggyAccountId() {
        return pluggyAccountId;
    }

    public void setPluggyAccountId(String pluggyAccountId) {
        this.pluggyAccountId = pluggyAccountId;
    }

    public ConexaoOpenFinanceEntity getConexaoOpenFinance() {
        return conexaoOpenFinance;
    }

    public void setConexaoOpenFinance(ConexaoOpenFinanceEntity conexaoOpenFinance) {
        this.conexaoOpenFinance = conexaoOpenFinance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountSubtype() {
        return accountSubtype;
    }

    public void setAccountSubtype(String accountSubtype) {
        this.accountSubtype = accountSubtype;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public BigDecimal getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(BigDecimal saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public LocalDateTime getDataUltimaAtt() {
        return dataUltimaAtt;
    }

    public void setDataUltimaAtt(LocalDateTime dataUltimaAtt) {
        this.dataUltimaAtt = dataUltimaAtt;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}
