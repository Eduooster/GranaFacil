package org.example.granafacil.core.gateways;

public interface PasswordEncoderGateway {
    String hash(String senhaPura);
    boolean matches(String senhaPura, String senhaHash);

}
