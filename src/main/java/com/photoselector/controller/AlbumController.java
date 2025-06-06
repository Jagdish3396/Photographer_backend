package com.photoselector.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.photographer.photoselector.entity.User;
import com.photographer.photoselector.service.AlbumService;
import com.photographer.photoselector.service.AuthService;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired private AlbumService albumService;
    @Autowired private AuthService authService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestParam String name, @RequestParam String photographerUsername) {
        User photographer = authService.getByUsername(photographerUsername).orElseThrow();
        return ResponseEntity.ok(albumService.createAlbum(name, photographer));
    }

    @PostMapping("/assign")
    public ResponseEntity<?> assign(@RequestParam Long albumId, @RequestParam Long userId) {
        return ResponseEntity.ok(albumService.assignUser(albumId, userId));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> userAlbums(@PathVariable String username) {
        User user = authService.getByUsername(username).orElseThrow();
        return ResponseEntity.ok(albumService.getAlbumsForUser(user));
    }
}
