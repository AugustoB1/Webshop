package com.senacsp.Webshop.config;

import com.senacsp.Webshop.entities.user.Admin;
import com.senacsp.Webshop.entities.user.Estoquista;
import com.senacsp.Webshop.entities.user.User;
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

        User u1 = new Admin("Augusto", "augusto@gmail.com","58498745852", "1195685-5454", "123");
        User u2 = new Estoquista("Brenno", "brenno@gmail.com", "45298745852", "123", "555555555");
        User u3 = new Estoquista("Deive", "deive@gmail.com", "58498545852", "123", "555555555");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
