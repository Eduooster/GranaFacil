package org.example.granafacil.core.usecases.UsuarioUseCases;

import org.example.granafacil.core.entities.Usuario;
import org.example.granafacil.core.exceptions.SenhaInvalidaException;

import org.example.granafacil.core.gateways.PasswordEncoderGateway;
import org.example.granafacil.core.gateways.TokenServiceGateway;
import org.example.granafacil.core.gateways.UsuarioGateway;

import java.util.Optional;


public class AutenticacaoUsuarioUseCase  {

    private final UsuarioGateway usuarioGateway;
    private final PasswordEncoderGateway passwordGateway;
    private final TokenServiceGateway tokenServiceGateway;

    public AutenticacaoUsuarioUseCase(
            UsuarioGateway usuarioGateway,
            PasswordEncoderGateway passwordGateway,
            TokenServiceGateway tokenServiceGateway) {
        this.usuarioGateway = usuarioGateway;
        this.passwordGateway = passwordGateway;
        this.tokenServiceGateway = tokenServiceGateway;
    }

    public String execute(String email, String senha) {


        Optional<Usuario> usuario = usuarioGateway.buscarPorEmail(email);

        boolean senhaValida = passwordGateway.matches(senha, usuario.get().getSenhaHash());
        if (!senhaValida) {
            throw new SenhaInvalidaException("Senha invalida");
        }

        return tokenServiceGateway.gerarToken(usuario.get().getId());
    }

}
