package org.javaprojects.mycode.admin;

import org.javaprojects.mycode.roles.Role;
import org.javaprojects.mycode.user.User;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

public interface AdminService {
    User removeUserFromRole(Long userId, Long roleId) throws RoleNotFoundException;
    User assignUerToRole(Long userId, Long roleId) throws RoleNotFoundException;
    Role removeAllUserFromRole(Long roleId) throws RoleNotFoundException;
    void deleteRole(Long roleId) throws RoleNotFoundException;
    List<Role> getAllRoles();
    Role createRole(Role theRole);

    Role findByName(String name) throws RoleNotFoundException;
    Role findById(Long roelId) throws RoleNotFoundException;
    Optional<User> getUserByEmail(String email);
    User add(User user);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User getUserById(Long id);
    User updateUser(Long id, User user);

}
