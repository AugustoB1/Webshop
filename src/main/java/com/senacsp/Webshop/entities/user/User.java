package com.senacsp.Webshop.entities.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.senacsp.Webshop.entities.user.enums.UserFuncao;
import com.senacsp.Webshop.entities.user.enums.UserStatus;
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
@JsonDeserialize(as = ConcreterUser.class)
public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private UserFuncao funcao;
    private UserStatus status;

    public User(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

}