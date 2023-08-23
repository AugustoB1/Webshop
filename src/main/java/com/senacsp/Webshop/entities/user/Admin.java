package com.senacsp.Webshop.entities.user;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Admin extends User{

    public Admin(String nome, String email, String telefone, String senha, UserStatus status) {
        super(nome, email, telefone, senha, status);
        setFuncao(UserFuncao.ADMIN);
    }
}
