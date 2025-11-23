package org.example.granafacil.infraestructure.integrations.pluggy;

import org.example.granafacil.infraestructure.integrations.pluggy.dto.AcessTokenResponse;
import org.example.granafacil.infraestructure.integrations.pluggy.dto.AuthResponse;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class PluggyService {

    private final PluggyAdapter pluggyAdapter;
    private String apiKey;
    private Instant expiration;

    public PluggyService(PluggyAdapter pluggyAdapter) {
        this.pluggyAdapter = pluggyAdapter;
    }



    public AcessTokenResponse getConnectToken() {
        return new AcessTokenResponse(pluggyAdapter.getConnectToken());
    }

    public synchronized String getApiKey() {
        if (apiKey == null || Instant.now().isAfter(expiration)) {

            String auth = pluggyAdapter.gerarApiKey();
            AuthResponse authResponse = new AuthResponse(auth);
            this.apiKey = authResponse.apiKey();
            this.expiration = Instant.now().plus(Duration.ofHours(2));
        }
        return apiKey;
    }

    public synchronized void forceRefresh() {
        apiKey = pluggyAdapter.gerarApiKey();
        expiration = Instant.now().plus(Duration.ofHours(2));
    }
}
