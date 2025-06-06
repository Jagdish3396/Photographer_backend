package com.photographer.photoselector.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Photo {
    @Id @GeneratedValue private Long id;
    private String fileName;
    private String storageUrl;
    @JsonBackReference
    @ManyToOne private Album album;
}
