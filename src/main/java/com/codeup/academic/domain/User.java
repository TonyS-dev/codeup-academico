/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academic.domain;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author tonys-dev
 */
public class User {
    private UUID id;
    private String username;
    private String password;
    private UserRole role;
    private AccessLevel accessLevel;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isActive;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = UserRole.TEACHER;
        this.accessLevel = AccessLevel.READ_WRITE;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.isActive = true;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
