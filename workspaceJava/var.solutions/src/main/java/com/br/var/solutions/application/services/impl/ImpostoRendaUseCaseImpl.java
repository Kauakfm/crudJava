package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.application.services.useCase.ImpostoRendaUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImpostoRendaUseCaseImpl implements ImpostoRendaUseCase {

    public String calculaImpostoRenda(double salario){
        return calculaFaixaImpostoRenda(salario);
    }


    // Regra : Base de calculon é salario Bruto X Aliquota - dedução;
    private String calculaFaixaImpostoRenda(double salario) {
        log.info("Inicaindo o calculo do imposto de renda:" + salario);
        String novoSalarioCalculado;

        if (salario < 1903.98) {
            return "isento";
        } else if (salario > 1903.98 && salario < 2826.65) {
            double calculoIRF = 142.80 - ((salario * 0.075) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);
            return novoSalarioCalculado;

        } else if (salario >= 2826.66 && salario < 3075.05) {
            double calculoIRF = 354.80 - ((salario * 0.15) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);
            return novoSalarioCalculado;
        } else if (salario >= 3751 && salario < 4664.68) {
            double calculoIRF = 636.13 - ((salario * 0.22) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);
            return novoSalarioCalculado;
        } else {
            double calculoIRF = 869.36 - ((salario * 275) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);
            return novoSalarioCalculado;
        }
    }
}
