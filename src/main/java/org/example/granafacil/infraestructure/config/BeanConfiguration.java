package org.example.granafacil.infraestructure.config;

import org.example.granafacil.core.application.gateways.*;
import org.example.granafacil.core.application.services.OpenFinanceApplicationService;
import org.example.granafacil.core.application.usecases.OpenFinanceUseCases.PluggyAuthUseCase;
import org.example.granafacil.core.application.usecases.OpenFinanceUseCases.PluggyClientConnectionUseCase;
import org.example.granafacil.core.application.usecases.OpenFinanceUseCases.PluggyClientItemUseCase;
import org.example.granafacil.core.application.usecases.UsuarioUseCases.*;
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
    public RegistrarUsuarioUseCase registrarUsuarioUseCase(UsuarioGateway usuarioGateway, PasswordEncoderGateway passwordEncoderGateway, TokenServiceGateway tokenServiceGateway) {
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

    @Bean
    public PluggyAuthUseCase pluggyAuthUseCase(PluggyGateway pluggyGateway) {
        return new PluggyAuthUseCase(pluggyGateway);
    }

    @Bean
    public PluggyClientConnectionUseCase pluggyClientConnectionUseCase(PluggyGateway pluggyGateway, PluggyAuthUseCase pluggyAuthUseCase) {
        return new PluggyClientConnectionUseCase(pluggyGateway,pluggyAuthUseCase);
    }

    @Bean
    public PluggyClientItemUseCase pluggyClientItemUseCase(UsuarioGateway usuarioGateway, ConexaoOpenFinanceGateway conexaoOpenFinanceGateway, InstituicaoFinanceiraGateway instituicaoFinanceiraGateway, OpenFinanceApplicationService openFinanceApplicationService) {
        return new PluggyClientItemUseCase(usuarioGateway,conexaoOpenFinanceGateway,instituicaoFinanceiraGateway,openFinanceApplicationService);
    }
}
