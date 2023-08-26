package com.senacsp.Webshop.services;

import com.senacsp.Webshop.entities.user.Admin;
import com.senacsp.Webshop.entities.user.User;
import com.senacsp.Webshop.entities.user.UserStatus;
import com.senacsp.Webshop.repositories.UserRepository;
import com.senacsp.Webshop.services.exceptions.RecursoNaoEncontradoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User atualizarStatus(String id){
        try{
            User user = userRepository.getReferenceById(id);
            ativarDesativar(user);
            return userRepository.save(user);
        }catch (EntityNotFoundException e){
            throw new RecursoNaoEncontradoException(id);
        }
    }

    private void ativarDesativar(User user){
        if (user.getStatus() == UserStatus.ATIVO){
            user.setStatus(UserStatus.INATIVO);
        }else{
            user.setStatus(UserStatus.ATIVO);
        }
    }

    public User atualizar(String id, User user){
        try{
            User entity = userRepository.getReferenceById(id);
            atualizarData(entity, user);
            return userRepository.save(entity);
        }catch (EntityNotFoundException e){
            throw new RecursoNaoEncontradoException(id);
        }
    }

    public void atualizarData(User entity, User user){
        entity.setNome(user.getNome());
        entity.setTelefone(user.getTelefone());
    }

    public Admin cadastrarAdmin(User user){
        Admin admin = new Admin(user.getNome(), user.getTelefone(), user.getEmail(), user.getSenha(), user.getStatus());
        return userRepository.save(admin);
    }



}
