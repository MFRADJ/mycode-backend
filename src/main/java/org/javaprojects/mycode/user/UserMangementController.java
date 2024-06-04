package org.javaprojects.mycode.user;

import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/admin/")
@RequiredArgsConstructor
@RestController
public class UserMangementController {


    private final UserRepository userRepository;

}