package com.horizonbuilders.server.config;

import com.horizonbuilders.server.model.Position;
import com.horizonbuilders.server.model.User;
import com.horizonbuilders.server.model.enums.ERole;
import com.horizonbuilders.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class AdminRegister implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByUsername("username")) {
            userRepository.save(
                    User.builder()
                            .username("username")
                            .password(passwordEncoder.encode("password"))
                            .firstName("firstName")
                            .lastName("lastName")
                            .photoUrl("someUrl")
                            .phoneNumber("3848328")
                            .address("Bishkek")
                            .enabled(true)
                            .position(Position.builder().name("admin").salary(1500).build())
                            .roles(Set.of(ERole.ADMIN))
                            .build()
            );
        }

    }
}
