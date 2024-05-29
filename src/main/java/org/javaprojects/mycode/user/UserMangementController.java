package org.javaprojects.mycode.user;

import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/admin/users")
@RequiredArgsConstructor
@RestController
public class UserMangementController {

    private final UserManagementService userService;
    private final UserRepository userRepository;

    @GetMapping("/findByEmail")
    public Optional<User> getUserByEmail(@RequestParam String email) {
       return userService.getUserByEmail(email);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @GetMapping("/getuserbyid/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id, Authentication authentication){
        Logger log = null;
        log.info("Authentication: {}", authentication);
        log.info("Authorities: {}", authentication.getAuthorities());

        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }
}