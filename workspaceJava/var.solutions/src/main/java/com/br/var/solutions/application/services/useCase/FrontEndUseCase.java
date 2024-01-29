package com.br.var.solutions.application.services.useCase;

import com.br.var.solutions.adapters.input.entities.PessoaRequest;
import com.br.var.solutions.adapters.input.entities.PessoaResponse;
import com.br.var.solutions.application.services.entities.informacoesIMC;

public interface FrontEndUseCase {
    PessoaResponse mapper (PessoaRequest pessoa, informacoesIMC imc, int anonascimento, String impostoRenda, String validaMundial, String saldoEmDolar);
}
