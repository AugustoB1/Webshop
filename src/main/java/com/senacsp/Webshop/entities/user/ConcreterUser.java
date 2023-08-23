package com.senacsp.Webshop.entities.user;

public class ConcreterUser extends User {

    public ConcreterUser() {
        super();
    }
    public ConcreterUser(String nome, String email, String phone, String password, UserStatus status) {
        super(nome, email, phone, password, status);
    }
}
