package org.javaprojects.mycode.admin;

import org.javaprojects.mycode.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @PostMapping("/promote/{userId}")
    public ResponseEntity<User> promoteToProfessor(@PathVariable Long userId) {
        try {
            User updatedUser = adminService.promoteToProfessor(userId);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
