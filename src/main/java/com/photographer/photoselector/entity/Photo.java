package com.photographer.photoselector.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

//@Entity
//@Data
//public class Photo {
//    @Id @GeneratedValue private Long id;
//    private String fileName;
//    private String storageUrl;
//    @JsonBackReference
//    @ManyToOne private Album album;
//}

@Entity
@Data
public class Photo {
    @Id @GeneratedValue private Long id;
    private String fileName;

    @Column(name = "storage_url") // keep DB column name intact
    private String url;

    @Transient // this won't be persisted in DB (optional)
    private boolean favorite = false;

    @JsonBackReference
    @ManyToOne
    private Album album;
}


