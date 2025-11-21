package org.example.granafacil.infraestructure.presentation;

import org.example.granafacil.core.usecases.UsuarioUseCases.AtualizarFormaGerenciarFinanancasUsuario;
import org.example.granafacil.core.usecases.UsuarioUseCases.AtualizarObjetivoPrincipalUsuario;
import org.example.granafacil.core.usecases.UsuarioUseCases.AtualizarPerfilFinanceiroUsuario;
import org.springframework.web.bind.annotation.GetMapping;

public class UsuarioController {

    private final AtualizarFormaGerenciarFinanancasUsuario atualizarFormaGerenciarFinanancasUsuario;
    private final AtualizarPerfilFinanceiroUsuario atualizarPerfilFinanceiroUsuario;
    private final AtualizarObjetivoPrincipalUsuario atualizarObjetivoPrincipalUsuario;


    public UsuarioController(AtualizarFormaGerenciarFinanancasUsuario atualizarFormaGerenciarFinanancasUsuario, AtualizarPerfilFinanceiroUsuario atualizarPerfilFinanceiroUsuario, AtualizarObjetivoPrincipalUsuario atualizarObjetivoPrincipalUsuario) {
        this.atualizarFormaGerenciarFinanancasUsuario = atualizarFormaGerenciarFinanancasUsuario;
        this.atualizarPerfilFinanceiroUsuario = atualizarPerfilFinanceiroUsuario;
        this.atualizarObjetivoPrincipalUsuario = atualizarObjetivoPrincipalUsuario;
    }
}
