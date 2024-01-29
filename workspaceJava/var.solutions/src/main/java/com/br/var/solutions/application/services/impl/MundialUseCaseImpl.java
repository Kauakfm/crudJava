package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.application.services.useCase.MundialUseCase;
import org.springframework.stereotype.Service;

@Service
public class MundialUseCaseImpl implements MundialUseCase {

    public String calculoMundial(String time){

        return calcularMundial(time);
    }

    private String calcularMundial(String time) {
        if (time.equalsIgnoreCase("Corinthians")) {
            return "Parabens o seu time possui 2 mundiais de clubes a FIFA";
        } else if (time.equalsIgnoreCase("São paulo")) {
            return "seu time tem 3 mundiais conforme a FIFA";
        } else if (time.equalsIgnoreCase("Santos")) {
            return "seu time tem 2 mundiais conforme a FIFA";
        }
        return "Poxam seu time não tem mundial KAKAKAKAKAKAKAKAKAKAKAKAKAK desiste desse time parça namoral";
    }


}
