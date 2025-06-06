package com.photographer.photoselector.dto;


//AuthResponse.java
public class AuthResponse {
 private String token;
 private String role; // "PHOTOGRAPHER" or "USER"
 private Long userId;

 public String getToken() {
     return token;
 }

 public void setToken(String token) {
     this.token = token;
 }

 public String getRole() {
     return role;
 }

 public void setRole(String role) {
     this.role = role;
 }

 public Long getUserId() {
     return userId;
 }

 public void setUserId(Long userId) {
     this.userId = userId;
 }
 // Getters & Setters
}
