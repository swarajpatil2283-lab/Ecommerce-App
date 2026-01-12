package com.ecommerce.service;
import com.ecommerce.domain.USER_ROLE;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class DatalnitializationComponent implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) {
        initializeAdminUser();
    }

    private void initializeAdminUser() {
        String adminUsername = "amitkumarprasad333@gmail.com";

        if (userRepository.findByEmail(adminUsername) == null) {
            User adminUser = new User();

            adminUser.setPassword(passwordEncoder.encode("AmitKumar@1995"));
            adminUser.setFullName("Amit");
            adminUser.setEmail(adminUsername);
            adminUser.setRole(USER_ROLE.ROLE_ADMIN);

            User admin = userRepository.save(adminUser);
        }

    }
}
