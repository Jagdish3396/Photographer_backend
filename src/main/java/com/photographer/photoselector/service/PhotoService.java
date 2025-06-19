package com.photographer.photoselector.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.photographer.photoselector.entity.Album;
import com.photographer.photoselector.entity.Photo;
import com.photographer.photoselector.repository.AlbumRepository;
import com.photographer.photoselector.repository.PhotoRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PhotoService {
	private final String uploadDir = "D://photoapp";

    @Autowired private PhotoRepository photoRepository;
    @Autowired private AlbumRepository albumRepository;

    public Photo uploadPhoto(MultipartFile file, Long albumId, String fileName) {
        try {
            // Check if album exists
            Album album = albumRepository.findById(albumId)
                    .orElseThrow(() -> new IllegalArgumentException("Album not found"));

            // Save file to disk
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadDir, fileName);
            Files.write(path, bytes);

            // Create and save Photo entity
            Photo photo = new Photo();
            photo.setFileName(fileName);
//            photo.setStorageUrl(path.toString());
            photo.setUrl(path.toString());
            photo.setAlbum(album);

            return photoRepository.save(photo);

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    public List<Photo> getPhotosByAlbum(Long albumId) {
        return photoRepository.findByAlbum_Id(albumId);
    }
}
