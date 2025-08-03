package com.icms.insurance.controller;

import com.icms.insurance.entity.User;
import com.icms.insurance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")  // good practice to prefix auth-related endpoints
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String result = userService.saveUser(user);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        String jwtToken = userService.login(user.getEmail(), user.getPassword());

        if (jwtToken != null) {
            return ResponseEntity.ok(jwtToken); // returns the JWT token string
        } else {
            return ResponseEntity
                    .badRequest()
                    .body("Invalid email or password");
        }
    }
    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(Authentication authentication) {
        String email = authentication.getName(); // This is the authenticated user's email
        User user = userService.findByEmail(email); // Fetch user by email
        return ResponseEntity.ok(user);
    }



}


