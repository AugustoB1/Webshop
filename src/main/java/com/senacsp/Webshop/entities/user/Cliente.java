package com.senacsp.Webshop.entities.user;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Cliente extends User{

    public Cliente(String nome, String email, String telefone, String senha, UserStatus status) {
        super(nome, email, telefone, senha, status);
        setFuncao(UserFuncao.CLIENTE);
    }
}
