package com.senacsp.Webshop.entities.user;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends User{

    public Cliente(String nome, String email, String telefone, String senha) {
        super(nome, email, telefone, senha);
        setRole(UserRole.CLIENTE);
    }
}
