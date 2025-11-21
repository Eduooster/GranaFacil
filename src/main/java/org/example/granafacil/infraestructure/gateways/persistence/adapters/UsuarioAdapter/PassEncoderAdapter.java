package org.example.granafacil.infraestructure.gateways.persistence.adapters.UsuarioAdapter;

import org.example.granafacil.core.gateways.PasswordEncoderGateway;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PassEncoderAdapter implements PasswordEncoderGateway {

    private final PasswordEncoder passwordEncoder;
    public PassEncoderAdapter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public String hash(String senhaPura) {
        return passwordEncoder.encode(senhaPura) ;
    }

    @Override
    public boolean matches(String senhaPura, String senhaHash) {
        return passwordEncoder.matches(senhaPura, senhaHash);
    }
}
