package org.example.granafacil.core.application.usecases.OpenFinanceUseCases;

import org.example.granafacil.core.application.dtos.PluggyItemData;
import org.example.granafacil.core.application.gateways.ConexaoOpenFinanceGateway;
import org.example.granafacil.core.application.gateways.InstituicaoFinanceiraGateway;
import org.example.granafacil.core.application.gateways.UsuarioGateway;

import org.example.granafacil.core.application.services.OpenFinanceApplicationService;
import org.example.granafacil.core.domain.entities.ConexaoOpenFinance;
import org.example.granafacil.core.domain.entities.InstituicaoFinanceira;
import org.example.granafacil.core.domain.entities.Usuario;
import org.example.granafacil.infraestructure.presentation.PluggyController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class PluggyClientItemUseCase {

    private static final Logger log = LoggerFactory.getLogger(PluggyClientItemUseCase.class);

    private final UsuarioGateway usuarioGateway;
    private final ConexaoOpenFinanceGateway conexaoGateway;
    private final InstituicaoFinanceiraGateway instituicaoGateway;
    private final OpenFinanceApplicationService openFinanceApplicationService;

    public PluggyClientItemUseCase(UsuarioGateway usuarioGateway, ConexaoOpenFinanceGateway conexaoGateway, InstituicaoFinanceiraGateway instituicaoGateway, OpenFinanceApplicationService openFinanceApplicationService) {
        this.usuarioGateway = usuarioGateway;
        this.conexaoGateway = conexaoGateway;
        this.instituicaoGateway = instituicaoGateway;
        this.openFinanceApplicationService = openFinanceApplicationService;
    }


    public void execute(PluggyItemData data) {
        log.info("Pluggyitem"+data.toString());

        Usuario usuario = usuarioGateway.buscaIdUsuario(data.getUsuarioId());

        log.info("INSTITUICAO");
        InstituicaoFinanceira inst = resolverInstituicao(data);
        log.info(inst.toString());

        resolverConexao(data, usuario, inst);
    }

    private InstituicaoFinanceira resolverInstituicao(PluggyItemData data) {
        return instituicaoGateway.buscarPorIdConnector(data.getConnectorId())
                .orElseGet(() -> {
                    InstituicaoFinanceira nova = openFinanceApplicationService.criarInstituicao(
                            data.getConnectorId(),
                            data.getConnectorName(),
                            data.getConnectorImageUrl(),
                            data.getConnectorHealth(),
                            data.getConnectorTypeBank()
                    );
                    log.info("nova"+ nova.toString());
                    instituicaoGateway.salvar(nova);
                    return nova;
                });
    }

    private void resolverConexao(PluggyItemData data, Usuario usuario, InstituicaoFinanceira inst) {
        Optional<ConexaoOpenFinance> existente = conexaoGateway.buscarPorItemId(data.getPluggyItemId());

        ConexaoOpenFinance conn = openFinanceApplicationService.atualizarConexao(
                existente,
                usuario,
                inst,
                data.getPluggyItemId(),
                data.getStatus(),
                data.getDataCriacao(),
                data.getDataExpiracaoToken(),
                data.getUltimoSync()
        );

        log.info("conexao open finance:" +conn.toString());
        conexaoGateway.salvar(conn);

    }


}
