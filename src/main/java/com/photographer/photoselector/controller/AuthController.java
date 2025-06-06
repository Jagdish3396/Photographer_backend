package com.photographer.photoselector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.photographer.photoselector.dto.AuthResponse;
import com.photographer.photoselector.entity.User;
import com.photographer.photoselector.model.Role;
import com.photographer.photoselector.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return ResponseEntity.ok(authService.register(user.getUsername(), user.getPassword(), user.getRole()));
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody User user) {
        String token = authService.login(user.getUsername(), user.getPassword());
        AuthResponse response=new AuthResponse();
        response.setRole("PHOTOGRAPHER");
        response.setToken(token);
        response.setUserId(1L);
      
        
        return response;
    }
}
