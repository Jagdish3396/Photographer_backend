package com.photographer.photoselector.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.photographer.photoselector.entity.Album;
import com.photographer.photoselector.entity.User;



public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByAssignedUsersContaining(User user);
    List<Album> findByPhotographer(User user);
}
