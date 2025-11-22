package org.example.granafacil.core.gateways;

import org.example.granafacil.core.entities.Usuario;
import org.example.granafacil.core.enums.FormaGerenciarFinancas;
import org.example.granafacil.core.enums.ObjetivoFinanceiro;
import org.example.granafacil.core.enums.PerfilFinanceiro;

import java.util.Optional;

public interface UsuarioGateway {
    void save(Usuario usuario);
    Usuario criar(Usuario usuario);
    Optional<Usuario> buscarPorEmail(String email);
    void atualizarObjetivo(Usuario usuario, ObjetivoFinanceiro objetivo);

    void atualizarFormaGerenciarFinancas(Usuario usuario, FormaGerenciarFinancas forma);

    void atualizarPerfilFinanceiro(Usuario usuario, PerfilFinanceiro perfil);
}
