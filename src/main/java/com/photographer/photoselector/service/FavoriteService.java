package com.photographer.photoselector.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photographer.photoselector.entity.Favorite;
import com.photographer.photoselector.entity.Photo;
import com.photographer.photoselector.entity.User;
import com.photographer.photoselector.repository.FavoriteRepository;
import com.photographer.photoselector.repository.PhotoRepository;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired private FavoriteRepository favoriteRepository;
    @Autowired private PhotoRepository photoRepository;

    public Favorite markFavorite(User user, Long photoId) {
        Photo photo = photoRepository.findById(photoId).orElseThrow();
        if (favoriteRepository.existsByUserAndPhoto(user, photo)) {
            throw new RuntimeException("Already marked as favorite.");
        }
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setPhoto(photo);
        return favoriteRepository.save(favorite);
    }

    public List<Favorite> getFavoritesByUser(User user) {
        return favoriteRepository.findByUser(user);
    }
}
