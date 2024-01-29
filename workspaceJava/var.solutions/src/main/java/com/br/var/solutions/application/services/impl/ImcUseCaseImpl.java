package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.application.services.useCase.ImcUseCase;
import com.br.var.solutions.application.services.entities.informacoesIMC;
import org.springframework.stereotype.Service;

@Service
public class ImcUseCaseImpl implements ImcUseCase {
    public informacoesIMC calculoImc(double peso, double altura){
         return calcularImc(peso,altura);
    }
    private informacoesIMC calcularImc(double peso, double altura) {
        double Imc = peso / (altura * altura);

        if (Imc <= 18.5) {
            return informacoesIMC.builder()
                    .imc(String.valueOf(Imc))
                    .classificacao("abaixo do peso")
                    .build();
        } else if (Imc >= 18.5 && Imc <= 24.9) {
            return informacoesIMC.builder()
            .imc(String.valueOf(Imc))
                    .classificacao("e voce esta no peso ideal")
                    .build();
        } else if (Imc > 24.9 && Imc <= 29.9) {
            return informacoesIMC.builder()
                    .imc(String.valueOf(Imc))
                    .classificacao(" e voce esta com exesso de peso")
                    .build();

        } else if (Imc > 29.9 && Imc <= 34.9) {
            return informacoesIMC.builder()
                    .imc(String.valueOf(Imc))
                    .classificacao("e voce esta com obesidade classe I")
                    .build();
        } else if (Imc > 34.9 && Imc <= 39.9) {
            return informacoesIMC.builder()
                    .imc(String.valueOf(Imc))
                    .classificacao("e voce esta com obesidade classe II")
                    .build();

        } else {
            return informacoesIMC.builder()
                    .imc(String.valueOf(Imc))
                    .classificacao("e voce esta com obesidade classe III")
                    .build();
        }
    }
}
