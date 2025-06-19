package com.photographer.photoselector.controller;

import com.photographer.photoselector.entity.Album;
import com.photographer.photoselector.entity.User;
import com.photographer.photoselector.repository.UserRepository;

import com.photographer.photoselector.security.JwtUtil;
import com.photographer.photoselector.service.AlbumService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;
    private final UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Album> createAlbum(
            @RequestHeader("Authorization") String token,
            @RequestParam String name) {

        String jwt = token.replace("Bearer ", "");
        String username = jwtUtil.getUsernameFromToken(token);

        User photographer = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Photographer not found"));

        Album album = albumService.createAlbum(name, photographer);
        return ResponseEntity.ok(album);
    }


    
    @GetMapping("/photographer")
    public ResponseEntity<List<Album>> getPhotographerAlbums(
            @RequestHeader("Authorization") String token) {

        String jwt = token.replace("Bearer ", ""); // strip "Bearer "
        String username = jwtUtil.getUsernameFromToken(jwt); // ✅ use the stripped JWT only

        User photographer = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Photographer not found"));

        List<Album> albums = albumService.getAlbumsByPhotographer(photographer);
        return ResponseEntity.ok(albums);
    }

    
    @GetMapping("/user")
    public ResponseEntity<List<Album>> getUserAlbums(@RequestHeader("Authorization") String token) {
        String jwt = token.replace("Bearer ", "");
        String username = jwtUtil.getUsernameFromToken(token);

        User user = userRepository.findByUsername(username)
          
                .orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(albumService.getAlbumsForUser(user));
    }

}
