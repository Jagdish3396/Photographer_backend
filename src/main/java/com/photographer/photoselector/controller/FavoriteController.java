package com.photographer.photoselector.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.photographer.photoselector.entity.User;
import com.photographer.photoselector.service.AuthService;
import com.photographer.photoselector.service.FavoriteService;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired private FavoriteService favoriteService;
    @Autowired private AuthService authService;

    @PostMapping("/mark")
    public ResponseEntity<?> markFavorite(@RequestParam String username, @RequestParam Long photoId) {
        User user = authService.getByUsername(username).orElseThrow();
        return ResponseEntity.ok(favoriteService.markFavorite(user, photoId));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getFavorites(@PathVariable String username) {
        User user = authService.getByUsername(username).orElseThrow();
        return ResponseEntity.ok(favoriteService.getFavoritesByUser(user));
    }
}
