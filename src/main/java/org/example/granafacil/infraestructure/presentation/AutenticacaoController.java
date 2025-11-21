package org.example.granafacil.infraestructure.presentation;

import org.example.granafacil.core.entities.Usuario;
import org.example.granafacil.core.usecases.UsuarioUseCases.AutenticacaoUsuarioUseCase;
import org.example.granafacil.core.usecases.UsuarioUseCases.RegistrarUsuarioUseCase;
import org.example.granafacil.infraestructure.dto.AutenticacaoDto.DadosAuthRequestDto;
import org.example.granafacil.infraestructure.dto.AutenticacaoDto.DadosTokenJwtResponseDto;
import org.example.granafacil.infraestructure.dto.UsuarioDto.UsuarioCreateRequestDto;
import org.example.granafacil.infraestructure.dto.UsuarioDto.UsuarioDetailResponseDto;
import org.example.granafacil.infraestructure.mapper.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private static final Logger log = LoggerFactory.getLogger(AutenticacaoController.class);
    private final AutenticacaoUsuarioUseCase autenticacaoUsuarioUseCase;
    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;
    private final UsuarioMapper usuarioMapper;

    public AutenticacaoController(AutenticacaoUsuarioUseCase autenticacaoUsuarioUseCase, RegistrarUsuarioUseCase registrarUsuarioUseCase, UsuarioMapper usuarioMapper) {
        this.autenticacaoUsuarioUseCase = autenticacaoUsuarioUseCase;
        this.registrarUsuarioUseCase = registrarUsuarioUseCase;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    public ResponseEntity autenticar(@RequestBody DadosAuthRequestDto dados) {
        String tokenJwt = autenticacaoUsuarioUseCase.execute(dados.email(), dados.senha());
        return ResponseEntity.ok(new DadosTokenJwtResponseDto(tokenJwt));
    }

    @PostMapping("/register")
    public ResponseEntity criar(@RequestBody UsuarioCreateRequestDto dto, UriComponentsBuilder uriBuilder) {

        String jwtNovoUsuario = registrarUsuarioUseCase.execute(
                dto.nome(),dto.sobrenome(),dto.email(),dto.senha(),dto.confirmarSenha());

        return ResponseEntity.status(HttpStatus.CREATED).body(new DadosTokenJwtResponseDto(jwtNovoUsuario));
    }

}
