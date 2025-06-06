package com.photographer.photoselector.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photographer.photoselector.entity.Album;
import com.photographer.photoselector.entity.User;


import com.photographer.photoselector.repository.AlbumRepository;
import com.photographer.photoselector.repository.UserRepository;

import java.util.List;

@Service
public class AlbumService {

    @Autowired private AlbumRepository albumRepository;
    @Autowired private UserRepository userRepository;

    public Album createAlbum(String name, User photographer) {
        Album album = new Album();
        album.setName(name);
        album.setPhotographer(photographer);
        return albumRepository.save(album);
    }

    public Album assignUser(Long albumId, Long userId) {
        Album album = albumRepository.findById(albumId).orElseThrow();
        com.photographer.photoselector.entity.User user = userRepository.findById(userId).orElseThrow();
        album.getAssignedUsers().add(user);
        return albumRepository.save(album);
    }

    public List<Album> getAlbumsForUser(User user) {
        return albumRepository.findByAssignedUsersContaining(user);
    }

    public List<Album> getAlbumsByPhotographer(User photographer) {
        return albumRepository.findByPhotographer(photographer);
    }
}
