package com.photographer.photoselector.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Favorite {
    @Id @GeneratedValue private Long id;

    @ManyToOne private User user;
    @ManyToOne private Photo photo;
}
