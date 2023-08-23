package com.senacsp.Webshop.entities.user;

public enum UserStatus {

    ATIVO("ativo"),
    INATIVO("inativo");

    private String status;

    UserStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
