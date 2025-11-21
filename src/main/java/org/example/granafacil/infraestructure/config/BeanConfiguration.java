package org.example.granafacil.infraestructure.config;

import org.example.granafacil.core.entities.Usuario;
import org.example.granafacil.core.gateways.PasswordEncoderGateway;
import org.example.granafacil.core.gateways.TokenServiceGateway;
import org.example.granafacil.core.gateways.UsuarioGateway;
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
    public AtualizarObjetivoPrincipalUsuario atualizarObjetivoPrincipalUsuario(UsuarioGateway usuarioGateway) {
        return new AtualizarObjetivoPrincipalUsuario(usuarioGateway);

    }
    @Bean
    public AtualizarFormaGerenciarFinanancasUsuario atualizarFormaGerenciarFinanancasUsuario(UsuarioGateway usuarioGateway) {
        return new AtualizarFormaGerenciarFinanancasUsuario(usuarioGateway);
    }

    @Bean
    public AtualizarPerfilFinanceiroUsuario atualizarPerfilFinanceiroUsuario(UsuarioGateway usuarioGateway) {
        return new AtualizarPerfilFinanceiroUsuario(usuarioGateway);
    }
}
