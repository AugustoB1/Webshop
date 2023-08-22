package com.senacsp.Webshop.entities.user;

public record UserDTO(String id, String nome, String email, String telefone, UserRole role) {
    public UserDTO(User user){
        this(user.getId(), user.getNome(), user.getEmail(), user.getTelefone(), user.getRole());
    }

}
