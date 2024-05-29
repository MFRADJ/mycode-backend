package org.javaprojects.mycode.user;

import lombok.RequiredArgsConstructor;
import org.javaprojects.mycode.exception.UserAlreadyExistsException;
import org.javaprojects.mycode.exception.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.javaprojects.mycode.roles.RoleRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService{


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository ;

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User add(User user) {

        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            throw new UserAlreadyExistsException("User with email "+user.getEmail()+" already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       // Role role = roleRepository.findByName("ROLE_USER").orElseThrow(()->new RuntimeException("Role not found"));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User with id "+id+" not found"));

    }

    @Override
    public User updateUser(Long id, User user) {

        User existingUser = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User with id "+id+" not found"));
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(existingUser);
    }
}
