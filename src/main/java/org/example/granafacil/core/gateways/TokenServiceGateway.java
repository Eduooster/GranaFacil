package org.example.granafacil.core.gateways;

import org.example.granafacil.core.entities.Usuario;

import java.time.Instant;
import java.time.LocalDateTime;

public interface TokenServiceGateway {
    String gerarToken(Long idUsuario);
    String getSubject(String token);
    Instant dataExpiracao();
}
