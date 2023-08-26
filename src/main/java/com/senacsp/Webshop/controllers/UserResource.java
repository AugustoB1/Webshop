package com.senacsp.Webshop.controllers;

import com.senacsp.Webshop.entities.user.Admin;
import com.senacsp.Webshop.entities.user.Estoquista;
import com.senacsp.Webshop.entities.user.User;
import com.senacsp.Webshop.entities.user.dto.UserDTO;
import com.senacsp.Webshop.repositories.UserRepository;
import com.senacsp.Webshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserService service;

    @Autowired
    UserRepository repository;
    @Autowired


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
    @PostMapping(value = "/cadastrar/admin")
    public ResponseEntity<User> cadastrarAdmin(@RequestBody User user){
        Admin admin = service.cadastrarAdmin(user);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}")
                .buildAndExpand(admin.getId()).toUri();
        return ResponseEntity.created(uri).body(admin);
    }
    @PostMapping(value = "/cadastrar/estoquista")
    public ResponseEntity<User> cadastrarEstoquista(@RequestBody User user){
        Estoquista estoquista = service.cadastrarEstoquista(user);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}")
                .buildAndExpand(estoquista.getId()).toUri();
        return ResponseEntity.created(uri).body(estoquista);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}