package com.senacsp.Webshop.entities.user;

import com.senacsp.Webshop.entities.user.enums.UserFuncao;
import com.senacsp.Webshop.entities.user.enums.UserStatus;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Admin extends User{

    public Admin(String nome, String email,String cpf, String telefone, String senha) {
        super(nome, email, cpf, telefone, senha);
        setFuncao(UserFuncao.ADMIN);
        setStatus(UserStatus.ATIVO);
    }
}
