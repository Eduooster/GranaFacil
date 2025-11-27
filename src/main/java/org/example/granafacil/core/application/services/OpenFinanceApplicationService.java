package org.example.granafacil.core.application.services;

import org.example.granafacil.core.application.usecases.OpenFinanceUseCases.PluggyClientItemUseCase;
import org.example.granafacil.core.domain.entities.ConexaoOpenFinance;
import org.example.granafacil.core.domain.entities.InstituicaoFinanceira;
import org.example.granafacil.core.domain.entities.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OpenFinanceApplicationService {
    private static final Logger log = LoggerFactory.getLogger(OpenFinanceApplicationService.class);
    public InstituicaoFinanceira criarInstituicao(
            Long connectorId,
            String name,
            String imageUrl,
            String health,
            String typeBank
    ) {
        InstituicaoFinanceira inst = InstituicaoFinanceira.novo(connectorId, name, imageUrl, health, typeBank);


        return inst;
    }


    public ConexaoOpenFinance atualizarConexao(
            Optional<ConexaoOpenFinance> existente,
            Usuario usuario,
            InstituicaoFinanceira inst,
            String pluggyItemId,
            String status,
            LocalDateTime dataCriacao,
            LocalDateTime dataExpiracao,
            LocalDateTime ultimoSync
    ) {

        ConexaoOpenFinance conn = existente.orElse(ConexaoOpenFinance.novo(status,dataCriacao,dataExpiracao,ultimoSync,pluggyItemId,inst,usuario));


        log.info("Criando Conexao: {}", conn);

        return conn;
    }

}
