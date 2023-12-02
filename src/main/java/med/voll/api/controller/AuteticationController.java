package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.user.User;
import med.voll.api.infra.security.TokenDadosJWT;
import med.voll.api.infra.security.TokenService;
import med.voll.api.user.DadosAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuteticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var AuthenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(AuthenticationToken);

        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDadosJWT(tokenJWT));
    }

}
