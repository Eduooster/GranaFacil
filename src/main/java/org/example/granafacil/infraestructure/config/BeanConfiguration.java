package org.example.granafacil.infraestructure.config;

import org.example.granafacil.core.gateways.PasswordEncoderGateway;
import org.example.granafacil.core.gateways.PluggyGateway;
import org.example.granafacil.core.gateways.TokenServiceGateway;
import org.example.granafacil.core.gateways.UsuarioGateway;
import org.example.granafacil.core.usecases.FinancaAuthUseCase.SincronizarFinancasUseCase;
import org.example.granafacil.core.usecases.UsuarioUseCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public AutenticacaoUsuarioUseCase autenticacaoUsuarioUseCase(UsuarioGateway usuarioGateway,
                                                                 PasswordEncoderGateway passwordEncoderGateway, TokenServiceGateway tokenServiceGateway) {
        return new AutenticacaoUsuarioUseCase(usuarioGateway, passwordEncoderGateway, tokenServiceGateway);
    }

    @Bean
    public RegistrarUsuarioUseCase registrarUsuarioUseCase(UsuarioGateway usuarioGateway,PasswordEncoderGateway passwordEncoderGateway,TokenServiceGateway tokenServiceGateway) {
        return new RegistrarUsuarioUseCase(passwordEncoderGateway,usuarioGateway,tokenServiceGateway);

    }

    @Bean
    public AtualizarObjetivoFinanceirolUsuario atualizarObjetivoFinanceiroUsuario(UsuarioGateway usuarioGateway) {
        return new AtualizarObjetivoFinanceirolUsuario(usuarioGateway);

    }
    @Bean
    public AtualizarFormaGerenciamentoFinancasUsuario atualizarFormaGerenciamentoFinancasUsuario(UsuarioGateway usuarioGateway) {
        return new AtualizarFormaGerenciamentoFinancasUsuario(usuarioGateway);
    }

    @Bean
    public AtualizarPerfilFinanceiroUsuario atualizarPerfilFinanceiroUsuario(UsuarioGateway usuarioGateway) {
        return new AtualizarPerfilFinanceiroUsuario(usuarioGateway);
    }


}
