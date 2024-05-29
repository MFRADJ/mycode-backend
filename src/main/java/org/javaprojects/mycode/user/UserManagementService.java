package org.javaprojects.mycode.user;

import java.util.List;
import java.util.Optional;


public interface UserManagementService {
    Optional<User> getUserByEmail(String email);
    User add(User user);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User getUserById(Long id);
    User updateUser(Long id, User user);
}
//