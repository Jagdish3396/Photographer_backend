package com.photographer.photoselector.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Album {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private User photographer;

    @ManyToMany
    private List<User> assignedUsers;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Photo> photos;

    // Getters and Setters
}
