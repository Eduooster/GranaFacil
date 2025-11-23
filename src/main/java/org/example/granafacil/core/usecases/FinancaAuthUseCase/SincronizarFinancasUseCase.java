package org.example.granafacil.core.usecases.FinancaAuthUseCase;

import org.example.granafacil.core.gateways.PluggyGateway;

public class SincronizarFinancasUseCase {

    private final PluggyGateway pluggyGateway;


    public SincronizarFinancasUseCase(PluggyGateway pluggyGateway) {
        this.pluggyGateway = pluggyGateway;
    }

    public void executar(String userId) {
        pluggyGateway.gerarApiKey();
       String accessToken =  pluggyGateway.getConnectToken();



    }
}