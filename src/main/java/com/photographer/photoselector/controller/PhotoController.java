package com.photographer.photoselector.controller;

import com.photographer.photoselector.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    @Autowired private PhotoService photoService;

    
    @PostMapping("/upload")
    public ResponseEntity<?> upload(
            @RequestPart("photo") MultipartFile file,
            @RequestPart("albumId") String albumId,
            @RequestPart("photoName") String photoName) {
        return ResponseEntity.ok(photoService.uploadPhoto(file, Long.valueOf(albumId), photoName));
    }



    @GetMapping("/album/{albumId}")
    public ResponseEntity<?> listByAlbum(@PathVariable Long albumId) {
        return ResponseEntity.ok(photoService.getPhotosByAlbum(albumId));
    }
}
