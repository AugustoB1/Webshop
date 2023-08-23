package com.senacsp.Webshop.entities.user;

public enum UserFuncao {
    ADMIN("admin"),
    CLIENTE("cliente");

    private String funcao;

    UserFuncao(String funcao){
        this.funcao = funcao;
    }

    public String getFuncao(){
        return funcao;
    }
}

