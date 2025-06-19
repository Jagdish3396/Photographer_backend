package com.photographer.photoselector.entity;
//
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
//
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
//
//@Entity
//@Data
//public class Album {
//    @Id @GeneratedValue private Long id;
//    private String name;
//
//    @ManyToOne private User photographer;
//
//    @ManyToMany
//    private List<User> assignedUsers;
//
// 
//    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Photo> photos;
//}
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data
public class Album {
    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("title")
    private String name; // Maps to title in JSON

    @JsonProperty("description")
    private String description; // Add this field to DB if needed

    @JsonProperty("photographerName")
    private String photographerName; // Optional – populate from User entity

    @ManyToOne
    private User photographer;

    @ManyToMany
    private List<User> assignedUsers;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Photo> photos;
}
