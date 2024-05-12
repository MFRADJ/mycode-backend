package org.javaprojects.mycode.user;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.javaprojects.mycode.exception.UserAlreadyExistsException;
import org.javaprojects.mycode.exception.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.javaprojects.mycode.roles.Role;
import org.javaprojects.mycode.roles.RoleRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService{


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository ;

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findUserById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        return user.get();
    }

//    @Override
//    public User add(User user) {Optional<User> theUser = userRepository.findByEmail(user.getEmail());
//        if (theUser.isPresent()){
//            throw new UserAlreadyExistsException("A user with " +user.getEmail() +" already exists");
//        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Role role = roleRepository.findByName("ROLE_USER").get();
//        user.setRoles(Collections.singletonList(role));
//        return userRepository.save(user);
//    }

//    @Override
//    public List<UserRecord> getAllUsers() {
//        return userRepository.findAll()
//                .stream()
//                .map(user -> new UserRecord(
//                        user.getId(),
//                        user.getFirstName(),
//                        user.getLastName(),
//                        user.getEmail(),
//                        new HashSet<>(user.getRoles()))).collect(Collectors.toList());
//    }
//
//    @Override
//    public void delete(String email) {
//        Optional<User> user = userRepository.findByEmail(email);
//        if (user.isEmpty()){
//            throw new UserNotFoundException("User with email " + email + " not found");
//        }
//        userRepository.deleteByEmail(email);
//    }
//
//    @Override
//    public User getUser(String email) {
//        Optional<User> user = userRepository.findByEmail(email);
//        if (user.isEmpty()){
//            throw new UserNotFoundException("User with email " + email + " not found");
//        }     return user.get();
//    }
//
//    @Override
//    public User update(User user) {
//        return null;
//    }

}
