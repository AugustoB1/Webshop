package com.senacsp.Webshop.controllers;

import com.senacsp.Webshop.entities.user.User;
import com.senacsp.Webshop.entities.user.UserDTO;
import com.senacsp.Webshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserRepository repository;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> users = this.repository.findAll().stream().map(UserDTO::new).toList();

        return ResponseEntity.ok().body(users);
    }
}