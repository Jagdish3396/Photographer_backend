package com.photographer.photoselector.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.photographer.photoselector.entity.Album;
import com.photographer.photoselector.entity.Photo;


public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findByAlbum(Album album);
    List<Photo> findByAlbum_Id(Long albumId);
}
