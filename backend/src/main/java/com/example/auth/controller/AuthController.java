package com.example.auth.controller;

import com.example.auth.entity.User;
import com.example.auth.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// @CrossOrigin(origins = "*")


@CrossOrigin(origins = "https://your-project.vercel.app")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            response.put("message", "Email already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        User savedUser = userRepository.save(user);
        response.put("message", "Signup successful");
        response.put("user", savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User loginRequest) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
            response.put("message", "Login successful");
            response.put("user", user.get());
            return ResponseEntity.ok(response);
        }
        response.put("message", "Invalid email or password");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
