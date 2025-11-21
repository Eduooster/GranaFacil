package org.example.granafacil.core.usecases.UsuarioUseCases;

import org.example.granafacil.core.entities.Usuario;
import org.example.granafacil.core.enums.ObjetivoPrincipal;
import org.example.granafacil.core.gateways.UsuarioGateway;

public class AtualizarObjetivoPrincipalUsuario {

    private final UsuarioGateway usuarioGateway;

    public AtualizarObjetivoPrincipalUsuario(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public void execute(Usuario usuario, ObjetivoPrincipal objetivoPrincipal) {
        Usuario usuarioBanco = usuarioGateway.buscarPorEmail(usuario.getEmail()).orElse(null);

        usuario.setObjetivo(objetivoPrincipal);
        usuarioGateway.atualizarObjetivo(usuario,objetivoPrincipal);
        usuarioGateway.save(usuarioBanco);

    }
}
