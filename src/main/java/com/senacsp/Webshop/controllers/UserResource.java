package com.senacsp.Webshop.controllers;

import com.senacsp.Webshop.entities.user.User;
import com.senacsp.Webshop.entities.user.UserDTO;
import com.senacsp.Webshop.repositories.UserRepository;
import com.senacsp.Webshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserService service;

    @Autowired
    UserRepository repository;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> users = this.repository.findAll().stream().map(UserDTO::new).toList();

        return ResponseEntity.ok().body(users);
    }

    @PutMapping(value = "/atualizarStatus/{id}")
    public ResponseEntity<User> atualizarStatus(@PathVariable String id, @RequestBody User user){
        user = service.atualizarStatus(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<User> atualizar(@PathVariable String id, @RequestBody User user){
        user = service.atualizar(id, user);
        return ResponseEntity.ok().body(user);
    }
}