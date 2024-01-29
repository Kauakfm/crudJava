package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.adapters.input.entities.Usuario;
import com.br.var.solutions.application.services.useCase.UsuarioUseCase;
import com.br.var.solutions.domain.entities.UsuarioEntity;
import com.br.var.solutions.domain.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    @Autowired
    UsuarioRepository usuarioRepository;
    public Usuario cadastraUsuario(Usuario user){
        return cadastroUser(user);
    }

    private Usuario cadastroUser(Usuario user) {

        UsuarioEntity entity = new UsuarioEntity();

        entity.setUsuario(user.getUsuario());
         entity.setNome(user.getNome());
         entity.setSenha(user.getSenha());

      UsuarioEntity novoUsuario =  usuarioRepository.save(entity);

        return  Usuario.builder()
              .id(novoUsuario.getId())
              .nome(novoUsuario.getNome())
              .usuario(novoUsuario.getUsuario())
              .senha(novoUsuario.getSenha())
              .build();



    }

}
