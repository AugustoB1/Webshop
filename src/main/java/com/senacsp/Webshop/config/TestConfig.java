package com.senacsp.Webshop.config;

import com.senacsp.Webshop.entities.user.User;
import com.senacsp.Webshop.entities.user.UserRole;
import com.senacsp.Webshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Augusto", "augusto@gmail.com", "teste", "teste", UserRole.ADMIN);
        User u2 = new User(null, "Brenno", "brenno@gmail.com", "teste", "teste", UserRole.USER);
        User u3 = new User(null, "Deive", "deive@gmail.com", "teste", "teste", UserRole.USER);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
