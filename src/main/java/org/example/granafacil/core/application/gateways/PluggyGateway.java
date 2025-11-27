package org.example.granafacil.core.application.gateways;


import reactor.core.publisher.Mono;

public interface PluggyGateway {
    String gerarApiKey();
    String getConnectToken();
    String getItem();



}
