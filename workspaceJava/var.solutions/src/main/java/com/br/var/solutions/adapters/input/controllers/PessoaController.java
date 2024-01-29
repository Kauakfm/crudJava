package com.br.var.solutions.adapters.input.controllers;


import com.br.var.solutions.adapters.input.entities.PessoaRequest;
import com.br.var.solutions.adapters.input.entities.PessoaResponse;
import com.br.var.solutions.application.services.entities.informacoesIMC;
import com.br.var.solutions.application.services.useCase.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*")
@Slf4j
public class PessoaController {

    //         1          2                          3                4
    // publico || privado //tipo de retorno // nome de metodo // parãmetros

@Autowired
  private MundialUseCase mundialUseCase;

@Autowired
private ImcUseCase ImcUseCase;
@Autowired
   private AnoNascimentoUseCase anoNascimentoUseCase;

@Autowired
   private ImpostoRendaUseCase impostoRendaUseCase;

@Autowired
private SaldoDolarUseCase saldoDolarUseCase;
@Autowired
   private FrontEndUseCase frontEndUseCase;
    //Endpoint
    @GetMapping
    public ResponseEntity<Object> get() {
        PessoaRequest pessoaRequest1 = new PessoaRequest();
        pessoaRequest1.setNome("kaua");
        pessoaRequest1.setSobrenome("ferreria");
        pessoaRequest1.setEndereco("Avenida CASTELO");
        pessoaRequest1.setIdade(17);
        return ResponseEntity.ok(pessoaRequest1);

    }

    @GetMapping("/resumo")
//                                                   tipo/objeto    apelido
    public ResponseEntity<Object> getPessoa(@RequestBody PessoaRequest pessoinha, @RequestParam(value = "valida_mundial") Boolean DesejaValidarMundial) {
        informacoesIMC Imc =    informacoesIMC.builder().build();
        int anonascimento = 0;
        String ImpostoRenda = null;
        String validaMundial = null;
        String saldoEmDolar = null;


        if (!pessoinha.getNome().isEmpty()) {

            log.info("iniciando o processo de resumo da pessoa:", pessoinha);

            if (Objects.nonNull(pessoinha.getPeso()) && Objects.nonNull(pessoinha.getAltura())) {
                log.info("iniciando o calculo do IMC");
                Imc = ImcUseCase.calculoImc(pessoinha.getPeso(), pessoinha.getAltura());
            }

            if (Objects.nonNull(pessoinha.getIdade())) {
                log.info("Iniciando calculo do ano de nascimento");
                anonascimento = anoNascimentoUseCase.calculaAnoNasc(pessoinha.getIdade());
            }

            if (Objects.nonNull((pessoinha.getSalario()))) {
                log.info("Iniciando calculo do imposto de renda");
                ImpostoRenda = impostoRendaUseCase.calculaImpostoRenda(pessoinha.getSalario());
            }

            if (Boolean.TRUE.equals(DesejaValidarMundial)) {
                if (Objects.nonNull(pessoinha.getTime())) {

                    log.info("Validando s e o time de coração tem mundial");
                    validaMundial = mundialUseCase.calculoMundial(pessoinha.getTime());
                }
            }


            if (Objects.nonNull(pessoinha.getSaldo())) {

                log.info("convertendo real em Dolar");
                saldoEmDolar = saldoDolarUseCase.converterSaldoDolar(pessoinha.getSaldo());
            }

            log.info("montando objeto de retorno para o front-end");
            PessoaResponse resumo = frontEndUseCase.mapper(pessoinha, Imc, anonascimento, ImpostoRenda, validaMundial, saldoEmDolar);

            return ResponseEntity.ok(resumo);
        }
        return ResponseEntity.noContent().build();
    }



}


