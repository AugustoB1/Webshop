package com.senacsp.Webshop.entities.user;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User{

    public Admin(String nome, String email, String telefone, String senha) {
        super(nome, email, telefone, senha);
        setRole(UserRole.ADMIN);
    }
}
