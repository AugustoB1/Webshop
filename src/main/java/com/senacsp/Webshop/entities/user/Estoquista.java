package com.senacsp.Webshop.entities.user;

import com.senacsp.Webshop.entities.user.enums.UserFuncao;
import com.senacsp.Webshop.entities.user.enums.UserStatus;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Estoquista extends User{

    public Estoquista(String nome, String email, String telefone, String senha, UserStatus status) {
        super(nome, email, telefone, senha, status);
        setFuncao(UserFuncao.CLIENTE);
    }
}