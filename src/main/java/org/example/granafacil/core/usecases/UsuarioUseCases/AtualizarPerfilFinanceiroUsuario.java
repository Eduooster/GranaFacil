package org.example.granafacil.core.usecases.UsuarioUseCases;

import org.example.granafacil.core.entities.Usuario;
import org.example.granafacil.core.enums.PerfilFinanceiro;
import org.example.granafacil.core.gateways.UsuarioGateway;

public class AtualizarPerfilFinanceiroUsuario {

    private final UsuarioGateway usuarioGateway;

    public AtualizarPerfilFinanceiroUsuario(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public void execute(Usuario usuario, PerfilFinanceiro perfil) {

        Usuario usuarioBanco = usuarioGateway.buscarPorEmail(usuario.getEmail()).orElse(null);
        usuarioBanco.setPerfil(perfil);
        usuarioGateway.save(usuarioBanco);

    }
}
