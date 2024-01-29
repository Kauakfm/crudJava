package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.application.services.useCase.SaldoDolarUseCase;
import org.springframework.stereotype.Service;

@Service
public class SaldoDolarUseCaseImpl implements SaldoDolarUseCase {
public String converterSaldoDolar(double saldo){
    return converteSaldoDolar(saldo);
}
    private String converteSaldoDolar(double saldo) {
        return String.valueOf(saldo / 5.11);
    }
}
