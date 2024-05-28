package org.javaprojects.mycode.user;

import java.util.List;


public interface UserManagementService {
    User add(User user);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User getUserById(Long id);
    User updateUser(Long id, User user);
}
//