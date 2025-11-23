package org.example.granafacil.infraestructure.integrations.pluggy;

import lombok.extern.slf4j.Slf4j;
import org.example.granafacil.core.gateways.PluggyGateway;
import org.example.granafacil.core.model.ItemResponse;
import org.example.granafacil.infraestructure.integrations.pluggy.dto.AcessTokenDto;
import org.example.granafacil.infraestructure.integrations.pluggy.dto.AcessTokenResponse;
import org.example.granafacil.infraestructure.integrations.pluggy.dto.AuthRequest;
import org.example.granafacil.infraestructure.integrations.pluggy.dto.AuthResponse;
import org.example.granafacil.infraestructure.presentation.AutenticacaoController;
import org.mapstruct.Qualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class PluggyAdapter implements PluggyGateway {

    private final String baseUrl = "https://api.pluggy.ai";
    String clientId = System.getenv("CLIENT_ID_PLUGGY");
    String clientSecret = System.getenv("CLIENT_SECRET_PLUGGY");

    private final WebClient webClient;
    private static final Logger log = LoggerFactory.getLogger(PluggyAdapter.class);

    public PluggyAdapter(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public String gerarApiKey() {
        AuthRequest body = new AuthRequest(clientId, clientSecret);

        log.info(body.toString());

        AuthResponse response = webClient.post()
                .uri("/auth")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(AuthResponse.class)
                .block();




        return response.apiKey();
    }

    @Override
    public String getConnectToken() {
        String apiKey = gerarApiKey();


        AcessTokenResponse response = webClient.post()
                .uri("/connect_token")
                .header("x-api-key", apiKey)
                .retrieve()
                .bodyToMono(AcessTokenResponse.class)
                .block();

        return response.accessToken();
    }

    @Override
    public ItemResponse getItem(String id) {
        return null;
    }

}
