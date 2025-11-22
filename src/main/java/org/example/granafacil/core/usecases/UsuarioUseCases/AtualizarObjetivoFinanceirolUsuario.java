package org.example.granafacil.core.usecases.UsuarioUseCases;

import org.example.granafacil.core.entities.Usuario;
import org.example.granafacil.core.enums.ObjetivoFinanceiro;
import org.example.granafacil.core.gateways.UsuarioGateway;

public class AtualizarObjetivoFinanceirolUsuario {

    private final UsuarioGateway usuarioGateway;

    public AtualizarObjetivoFinanceirolUsuario(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public void execute(Usuario usuario, ObjetivoFinanceiro objetivoFinanceiro) {
        Usuario usuarioBanco = usuarioGateway.buscarPorEmail(usuario.getEmail()).orElse(null);

        usuarioBanco.setObjetivo(objetivoFinanceiro);
        usuarioGateway.save(usuarioBanco);

    }
}
