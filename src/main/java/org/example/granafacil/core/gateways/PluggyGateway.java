package org.example.granafacil.core.gateways;

import org.example.granafacil.core.model.ItemResponse;

public interface PluggyGateway {
    String gerarApiKey();
    String getConnectToken();
    ItemResponse getItem(String id);
    //AccountResponse getAccounts(String itemId);

}
