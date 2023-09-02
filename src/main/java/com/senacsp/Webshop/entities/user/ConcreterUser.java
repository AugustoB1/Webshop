package com.senacsp.Webshop.entities.user;

import com.senacsp.Webshop.entities.user.enums.UserStatus;

public class ConcreterUser extends User {

    public ConcreterUser() {
        super();
    }
    public ConcreterUser(String nome, String email, String phone, String password, String cpf) {
        super(nome, email, phone, password, cpf);
    }
}
