package com.photographer.photoselector.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.photographer.photoselector.entity.Favorite;
import com.photographer.photoselector.entity.Photo;
import com.photographer.photoselector.entity.User;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUser(User user);
    List<Favorite> findByPhoto(Photo photo);
    boolean existsByUserAndPhoto(User user, Photo photo);
}
