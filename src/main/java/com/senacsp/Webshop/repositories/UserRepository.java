package com.senacsp.Webshop.repositories;

import com.senacsp.Webshop.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM users WHERE nome = :nome", nativeQuery = true)
    List<User> findByNome(@Param("nome") String nome);
}

