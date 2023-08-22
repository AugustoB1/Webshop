package com.senacsp.Webshop.entities.user;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    public User(String nome, String email, String phone, String password) {
        this.nome = nome;
        this.email = email;
        this.telefone = phone;
        this.senha = password;
    }

}