package com.senacsp.Webshop.repositories;

import com.senacsp.Webshop.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
