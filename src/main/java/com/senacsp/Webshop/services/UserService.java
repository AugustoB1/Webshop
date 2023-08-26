package com.senacsp.Webshop.services;

import com.senacsp.Webshop.entities.user.Admin;
import com.senacsp.Webshop.entities.user.Estoquista;
import com.senacsp.Webshop.entities.user.User;
import com.senacsp.Webshop.entities.user.enums.UserStatus;
import com.senacsp.Webshop.repositories.UserRepository;
import com.senacsp.Webshop.services.exceptions.DatabaseException;
import com.senacsp.Webshop.services.exceptions.RecursoNaoEncontradoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
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
            String criptografando = this.passwordEncoder.encode(user.getSenha());
            user.setSenha(criptografando);
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
        String criptografando = this.passwordEncoder.encode(user.getSenha());
        user.setSenha(criptografando);
        Admin admin = new Admin(user.getNome(), user.getTelefone(), user.getEmail(), user.getSenha(), user.getStatus());
        return userRepository.save(admin);
    }

    public Estoquista cadastrarEstoquista(User user){
        String criptografando = this.passwordEncoder.encode(user.getSenha());
        user.setSenha(criptografando);
        Estoquista estoquista = new Estoquista(user.getNome(), user.getTelefone(), user.getEmail(), user.getSenha(), user.getStatus());
        return userRepository.save(estoquista);
    }

    public void delete(String id){
        try {
            Optional<User> user = userRepository.findById(id);
            if(user.isEmpty()){
                throw new RecursoNaoEncontradoException(id);
            }
            userRepository.deleteById(id);
        }
        catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    public boolean validarSenha(User user) {
        String senha = userRepository.getById(user.getId()).getSenha();
        boolean valid = passwordEncoder.matches(user.getSenha(), senha);
        return valid;
    }
}
