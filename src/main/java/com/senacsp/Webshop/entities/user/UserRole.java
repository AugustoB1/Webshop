package com.senacsp.Webshop.entities.user;

public enum UserRole {
    ADMIN("admin"),
    CLIENTE("cliente");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}

