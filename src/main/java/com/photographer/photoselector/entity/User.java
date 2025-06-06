package com.photographer.photoselector.entity;

import java.util.List;

import com.photographer.photoselector.model.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class User {
    @Id @GeneratedValue private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role; // PHOTOGRAPHER, USER

    @ManyToMany(mappedBy = "assignedUsers")
    private List<Album> albums;
}
