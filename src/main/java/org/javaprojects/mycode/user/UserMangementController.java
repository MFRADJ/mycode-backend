package org.javaprojects.mycode.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserMangementController {

    private final UserManagementService userService;

//    @GetMapping("/admin/get-all-users")
//    public ResponseEntity<List<UserRecord>> getAllUsers(){
//        return ResponseEntity.ok(userService.getAllUsers());
//
//    }

    @GetMapping("/admin/get-users/{userId}")
    public ResponseEntity<Optional<Object>> getUSerById(@PathVariable Long id){
        return ResponseEntity.ok(Optional.ofNullable(userService.getUserById(id)));

    }

//    @PutMapping("/admin/update/{userId}")
//    public ResponseEntity<Userdto> updateUser(@PathVariable Integer userId, @RequestBody User user){
//        return ResponseEntity.ok(userService.updateUser(userId, user));
//    }
//
//    @GetMapping("/adminuser/get-profile")
//    public ResponseEntity<Userdto> getMyProfile(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//        Userdto response = userService.getMyInfo(email);
//        return  ResponseEntity.status(response.getStatusCode()).body(response);
//    }
//
//    @DeleteMapping("/admin/delete/{userId}")
//    public ResponseEntity<Userdto> deleteUSer(@PathVariable Integer userId){
//        return ResponseEntity.ok(userService.deleteUser(userId));
//    }

}