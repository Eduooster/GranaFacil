package org.example.granafacil.core.usecases.UsuarioUseCases;

import org.example.granafacil.core.entities.Usuario;
import org.example.granafacil.core.enums.FormaGerenciarFinancas;
import org.example.granafacil.core.enums.PerfilFinanceiro;
import org.example.granafacil.core.gateways.UsuarioGateway;

public class AtualizarFormaGerenciarFinanancasUsuario {

    private final UsuarioGateway usuarioGateway;

    public AtualizarFormaGerenciarFinanancasUsuario(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public void execute(Usuario usuario, FormaGerenciarFinancas formaGerenciarFinancas) {
        Usuario usuarioBanco = usuarioGateway.buscarPorEmail(usuario.getEmail()).orElse(null);
        usuarioBanco.setFinancas(formaGerenciarFinancas);
        usuarioGateway.save(usuarioBanco);
    }
}
