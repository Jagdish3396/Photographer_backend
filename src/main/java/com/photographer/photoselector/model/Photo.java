package com.photographer.photoselector.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Photo {
    @Id @GeneratedValue
    private Long id;

    private String fileName;
    private String storageUrl;

    @ManyToOne
    private Album album;

    // Getters and Setters
}
