package com.br.var.solutions.application.services.entities;

public class ValidaUsuario {

    public enum ValidaUser{
        USER_1("var", "12345678"),
        USER_2("kaua.martins", "teste"),
        USER_3("aluno_var", "senha1234");

        private String usuario;
        private String senha;

        ValidaUser(String username, String password){
            this.usuario = username;
            this.senha = password;
        }

        public  String getUsuario(){
            return usuario;

        }
            public String getSenha(){
            return senha;
        }
    }

    public static Boolean validaUsuario(String username, String password){
        for(ValidaUser validaUser : ValidaUser.values()){
            if(validaUser.getUsuario().equalsIgnoreCase(username) && validaUser.getSenha().equals(password)){
               return true;
            }
        }
        return false;
    }
    public static String returnUsername(String username) {
        for (ValidaUser validaUser : ValidaUser.values()) {
            if (validaUser.getUsuario().equalsIgnoreCase(username)) {
                return validaUser.getUsuario();
            }
        }
        return null;
    }

    public static String returnPassword(String username) {
        for (ValidaUser validaUser : ValidaUser.values()) {
            if (validaUser.getUsuario().equalsIgnoreCase(username)) {
                return validaUser.getSenha();
            }
        }
        return null;
    }
}
