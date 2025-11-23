package org.example.granafacil.core.usecases.FinancaAuthUseCase;

import org.example.granafacil.core.gateways.PluggyGateway;
import org.example.granafacil.core.gateways.UsuarioGateway;

public class ListarConnectorUseCase {

    private final PluggyGateway gateway;


    public ListarConnectorUseCase(PluggyGateway gateway) {
        this.gateway = gateway;
    }
}
