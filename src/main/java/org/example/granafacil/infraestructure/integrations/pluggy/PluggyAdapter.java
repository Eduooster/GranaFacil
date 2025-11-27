package org.example.granafacil.infraestructure.integrations.pluggy;

import org.example.granafacil.core.application.gateways.PluggyGateway;
import org.example.granafacil.infraestructure.presentation.dto.pluggyDto.AcessTokenResponse;
import org.example.granafacil.infraestructure.presentation.dto.pluggyDto.AuthRequest;
import org.example.granafacil.infraestructure.presentation.dto.pluggyDto.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class PluggyAdapter implements PluggyGateway {

    private final WebClient webClient;
    private final String clientId = System.getenv("CLIENT_ID_PLUGGY");
    private final String clientSecret = System.getenv("CLIENT_SECRET_PLUGGY");

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


        log.info(response.toString());



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
        log.info("acess tken "+response.toString());

        return response.accessToken();
    }

    @Override
    public String getItem() {
        String apiKey = gerarApiKey();



        return "";
    }


}
