package com.senacsp.Webshop.entities.user.dto;

import com.senacsp.Webshop.entities.user.User;
import com.senacsp.Webshop.entities.user.enums.UserFuncao;
import com.senacsp.Webshop.entities.user.enums.UserStatus;

public record UserDTO(String id, String nome, String email, String telefone, UserFuncao role, UserStatus status) {
    public UserDTO(User user){
        this(user.getId(), user.getNome(), user.getEmail(), user.getTelefone(), user.getFuncao(), user.getStatus());
    }

}
