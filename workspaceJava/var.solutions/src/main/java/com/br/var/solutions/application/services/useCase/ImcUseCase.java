package com.br.var.solutions.application.services.useCase;


import com.br.var.solutions.application.services.entities.informacoesIMC;

public interface ImcUseCase {
    informacoesIMC calculoImc(double peso, double altura);
}
