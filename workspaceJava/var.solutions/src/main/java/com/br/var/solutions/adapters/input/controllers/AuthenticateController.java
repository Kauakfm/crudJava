package com.br.var.solutions.adapters.input.controllers;

import com.br.var.solutions.adapters.input.entities.GenerateToken;
import com.br.var.solutions.application.services.entities.ValidaUsuario;
import com.br.var.solutions.infraestructure.config.security.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@Slf4j
public class AuthenticateController {
    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<GenerateToken> generateToken(@RequestParam("client_id") String client_id,
                                                       @RequestParam("password") String password) {

        log.info("Inicaiando a tentativa de geração de token para o usuário:"  + client_id);
        //criar um enum para validar um clientId e passoword.
        Boolean validaUsuario = ValidaUsuario.validaUsuario(client_id, password);

        if (Boolean.FALSE.equals(validaUsuario)) {
            log.error("não foi possivel gerar o token, pois o usuario ou senha são incorreto.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GenerateToken());
        }

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

        String token = jwtTokenUtil.generateToken(client_id);


        GenerateToken tokenResponse = new GenerateToken();
        tokenResponse.setToken(token);

        log.info("token geraco com sucesso para o usuario:"  + client_id + " em:" + System.currentTimeMillis());



        return ResponseEntity.ok(tokenResponse);
    }
}

