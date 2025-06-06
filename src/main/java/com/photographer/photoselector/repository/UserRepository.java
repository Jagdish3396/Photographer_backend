package com.photographer.photoselector.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.photographer.photoselector.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
