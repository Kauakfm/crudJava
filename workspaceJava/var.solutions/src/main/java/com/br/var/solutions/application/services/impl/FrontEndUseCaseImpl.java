package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.adapters.input.entities.PessoaRequest;
import com.br.var.solutions.adapters.input.entities.PessoaResponse;
import com.br.var.solutions.application.services.useCase.FrontEndUseCase;
import com.br.var.solutions.application.services.entities.informacoesIMC;
import org.springframework.stereotype.Service;

@Service
public class FrontEndUseCaseImpl implements FrontEndUseCase {

    public PessoaResponse  mapper(PessoaRequest pessoa, informacoesIMC imc, int anonascimento, String impostoRenda, String validaMundial, String saldoEmDolar){
        return complementarRespostaFrontEnd(pessoa,imc,anonascimento,impostoRenda,validaMundial,saldoEmDolar);
    }
    private PessoaResponse complementarRespostaFrontEnd(PessoaRequest pessoa, informacoesIMC imc, int anonascimento, String impostoRenda, String validaMundial, String saldoEmDolar) {

        PessoaResponse response = new PessoaResponse();

        response.setNome(pessoa.getNome());
        response.setImc(imc.getImc());
        response.setClassificacaoIMC(imc.getClassificacao());
        response.setSalario(impostoRenda);
        response.setAnoNascimento(anonascimento);
        response.setMundialClubes(validaMundial);
        response.setSaldoEmDolar(saldoEmDolar);
        response.setIdade(pessoa.getIdade());
        response.setTime(pessoa.getTime());
        response.setSobrenome(pessoa.getSobrenome());
        response.setEndereco(pessoa.getEndereco());
        response.setAltura(pessoa.getAltura());
        response.setPeso(pessoa.getPeso());
        response.setSaldo(pessoa.getSaldo());


        return response;
    }
}
