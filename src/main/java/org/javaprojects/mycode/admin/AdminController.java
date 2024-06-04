package org.javaprojects.mycode.admin;

import lombok.RequiredArgsConstructor;
import org.javaprojects.mycode.roles.Role;
import org.javaprojects.mycode.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private Role role;
    private User user;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = adminService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = adminService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users/email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        Optional<User> user = adminService.getUserByEmail(email);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = adminService.add(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = adminService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Role endpoints

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = adminService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long roleId) {

        try {
            role = adminService.findById(roleId);
        } catch (RoleNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @GetMapping("/roles/name")
    public ResponseEntity<Role> getRoleByName(@RequestParam String name) {

        try {
            role = adminService.findByName(name);
        } catch (RoleNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role createdRole = adminService.createRole(role);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        try {
            adminService.deleteRole(id);
        } catch (RoleNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/roles/{roleId}/users/{userId}")
    public ResponseEntity<User> assignUserToRole(@PathVariable Long roleId, @PathVariable Long userId) {

        try {
            user = adminService.assignUerToRole(userId, roleId);
        } catch (RoleNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/roles/{roleId}/users/{userId}")
    public ResponseEntity<User> removeUserFromRole(@PathVariable Long roleId, @PathVariable Long userId) {

        try {
            user = adminService.removeUserFromRole(userId, roleId);
        } catch (RoleNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/roles/{id}/users")
    public ResponseEntity<Role> removeAllUsersFromRole(@PathVariable Long id) {

        try {
            role = adminService.removeAllUserFromRole(id);
        } catch (RoleNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
