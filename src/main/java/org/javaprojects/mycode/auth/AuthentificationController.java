package org.javaprojects.mycode.auth;


import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor

public class AuthentificationController {

    private final AuthentifictionService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequest request)  {
        try {
            service.register(request);
            return ResponseEntity.accepted().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (MessagingException e) {
            return ResponseEntity.status(500).body("Error sending validation email");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred during registration");
        }
    }
    @PostMapping("/authenticate")
            public ResponseEntity<AuthentificationResponse> authenticate(@RequestBody AuthentificationRequest request) {
                return ResponseEntity.ok(service.authenticate(request));
    }
    @GetMapping("/activate-account")
            public void confirm(@RequestParam String token) throws MessagingException {
                service.activateAccount(token);
    }

}