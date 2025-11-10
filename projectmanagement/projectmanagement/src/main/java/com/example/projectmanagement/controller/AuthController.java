package com.example.projectmanagement.controller;

import com.example.projectmanagement.dto.RegisterRequest;
import com.example.projectmanagement.model.User;
import com.example.projectmanagement.repository.UserRepository;
import jakarta.validation.Valid;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordEncoder encoder;

	@PostMapping("/registerUser")
	public ResponseEntity<Map<String, String>> register(@Valid @RequestBody RegisterRequest req) {
		if (userRepo.existsByUsername(req.getUsername())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", "Username already exists"));
		}

		User u = new User();
		u.setUsername(req.getUsername());
		u.setPassword(encoder.encode(req.getPassword()));
		userRepo.save(u);

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "User registered successfully"));
	}
	
	@PostMapping("/loginUser")
	public ResponseEntity<Map<String, String>> login(@Valid @RequestBody RegisterRequest req) {
		Optional<User> user = userRepo.findByUsername(req.getUsername());

		if (user.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid username or password"));
		}

		if (!encoder.matches(req.getPassword(), user.get().getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid username or password"));
		}

		return ResponseEntity.ok(Map.of("message", "Login successful", "username", user.get().getUsername()));
	}

}
