package org.javaprojects.mycode.admin;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.javaprojects.mycode.exception.RoleAlreadyExistException;
import org.javaprojects.mycode.exception.UserAlreadyExistsException;
import org.javaprojects.mycode.exception.UserNotFoundException;
import org.javaprojects.mycode.roles.Role;
import org.javaprojects.mycode.roles.RoleRepository;
import org.javaprojects.mycode.user.User;
import org.javaprojects.mycode.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository ;


    @Override
    public User removeUserFromRole(Long userId, Long roleId) throws RoleNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RoleNotFoundException("Role with id " + roleId + " not found"));

        user.getRoles().remove(role);
        role.getUsers().remove(user);

        userRepository.save(user);
        roleRepository.save(role);

        return user;
    }

    @Override
    public User assignUerToRole(Long userId, Long roleId) throws RoleNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RoleNotFoundException("Role with id " + roleId + " not found"));

        user.getRoles().add(role);
        role.getUsers().add(user);

        userRepository.save(user);
        roleRepository.save(role);

        return user;
    }

    @Override
    public Role removeAllUserFromRole(Long roleId) throws RoleNotFoundException {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RoleNotFoundException("Role with id " + roleId + " not found"));

        for (User user : role.getUsers()) {
            user.getRoles().remove(role);
            userRepository.save(user);
        }
        role.getUsers().clear();
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) throws RoleNotFoundException {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role with id " + id + " not found"));

        for (User user : role.getUsers()) {
            user.getRoles().remove(role);
            userRepository.save(user);
        }

        roleRepository.delete(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(Role theRole) {
        Optional<Role> checkRole = roleRepository.findByName(theRole.getName());
        if (checkRole.isPresent()){
            throw new RoleAlreadyExistException(checkRole.get().getName()+ " role already exist");
        }
        return roleRepository.save(theRole);

    }

    @Override
    public Role findByName(String name) throws RoleNotFoundException {
        return roleRepository.findByName(name).orElseThrow(() -> new RoleNotFoundException("Role with name " + name + " not found"));
    }

    @Override
    public Role findById(Long id) throws RoleNotFoundException {
        return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role with id " + id + " not found"));

    }

    @Override
    public Optional<User> getUserByEmail(String email) {
       return userRepository.findByEmail(email);
    }

    @Override
    public User add(@NotNull User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            throw new UserAlreadyExistsException("User with email "+user.getEmail()+" already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
    public User updateUser(Long id, @NotNull User user) {
        User existingUser = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User with id "+id+" not found"));
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(existingUser);

    }

}
