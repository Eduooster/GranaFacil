package org.example.granafacil.core.application.usecases.UsuarioUseCases;

import org.example.granafacil.core.domain.entities.Usuario;
import org.example.granafacil.core.domain.enums.FormaGerenciarFinancas;
import org.example.granafacil.core.application.gateways.UsuarioGateway;

public class AtualizarFormaGerenciamentoFinancasUsuario {

    private final UsuarioGateway usuarioGateway;

    public AtualizarFormaGerenciamentoFinancasUsuario(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public void execute(Usuario usuario, FormaGerenciarFinancas formaGerenciarFinancas) {
        Usuario usuarioBanco = usuarioGateway.buscarPorEmail(usuario.getEmail()).orElse(null);
        usuarioBanco.setFinancas(formaGerenciarFinancas);
        usuarioGateway.save(usuarioBanco);
    }
}
