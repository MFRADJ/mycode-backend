package org.javaprojects.mycode.admin;

import jakarta.transaction.Transactional;
import org.javaprojects.mycode.roles.Role;
import org.javaprojects.mycode.roles.RoleRepository;
import org.javaprojects.mycode.user.User;
import org.javaprojects.mycode.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public User promoteToProfessor(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = userOpt.get();
        Role professorRole = roleRepository.findByName("ROLE_PROFESSOR")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.getRoles().add(professorRole);
        return userRepository.save(user);
    }
}
