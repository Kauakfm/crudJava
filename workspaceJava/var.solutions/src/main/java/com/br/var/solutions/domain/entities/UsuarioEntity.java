package com.br.var.solutions.domain.entities;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "TabUsuario")
@Entity
public class UsuarioEntity {

    @Id
    private int id;

    private String nome;

    private String usuario;

    private String senha;

}
