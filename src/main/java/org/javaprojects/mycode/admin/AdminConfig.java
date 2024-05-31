package org.javaprojects.mycode.admin;
import org.javaprojects.mycode.roles.Role;
import org.javaprojects.mycode.roles.RoleRepository;
import org.javaprojects.mycode.user.User;
import org.javaprojects.mycode.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Optional;

@Configuration

public class AdminConfig {

    @Value("${admin.firstName}")  // Default value if not specified
    private  String adminFirstName;

    @Value("${admin.lastName}")    // Default value if not specified
    private  String adminLastName;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (userRepository.findByEmail(adminEmail).isEmpty()) {
            Optional<Role> optionalAdminRole = roleRepository.findByName("ROLE_ADMIN");
            Role adminRole;

            if (optionalAdminRole.isEmpty()) {
                adminRole = new Role();
                adminRole.setName("ROLE_ADMIN");
                roleRepository.save(adminRole);
            } else {
                adminRole = optionalAdminRole.get();
            }

            User admin = new User();
            admin.setEmail(adminEmail);
            admin.setFirstName(adminFirstName);
            admin.setLastName(adminLastName);
            admin.setPassword(passwordEncoder.encode(adminPassword));
            admin.setRoles(Collections.singletonList(adminRole));
            userRepository.save(admin);
        }
    }
}
