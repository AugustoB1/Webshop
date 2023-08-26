package com.senacsp.Webshop.entities.user.enums;

public enum UserFuncao {
    ADMIN("admin"),
    ESTOQUISTA("estoquista");

    private String funcao;

    UserFuncao(String funcao){
        this.funcao = funcao;
    }

    public String getFuncao(){
        return funcao;
    }
    public static UserStatus valueOfFuncao(String funcao) {
        for (UserStatus userStatus : UserStatus.values()) {
            if (userStatus.getStatus().equals(funcao)) {
                return userStatus;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + funcao);
    }
}

