/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academico.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.codeup.academico.domain.User;
import com.codeup.academico.util.PasswordUtils;

/**
 *
 * @author tonys-dev
 */
public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());
    private final DataBase dataBase;
    
    public UserService() {
        this.dataBase = new DataBase();
    }
    
    /**
     * Authenticate a user with username and password
     */
    public boolean authenticate(String username, String password) {
        try {
            if (username == null || username.trim().isEmpty() || 
                password == null || password.trim().isEmpty()) {
                return false;
            }
            
            User user = dataBase.findUserByUsername(username.trim());
            if (user == null) {
                logger.log(Level.WARNING, "Login attempt for non-existent user: {0}", username);
                return false;
            }
            
            boolean isValid = PasswordUtils.checkPassword(password, user.getPassword());
            if (isValid) {
                logger.log(Level.INFO, "Successful login for user: {0}", username);
            } else {
                logger.log(Level.WARNING, "Failed login attempt for user: {0}", username);
            }
            
            return isValid;
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during authentication for user: " + username, e);
            return false;
        }
    }
    
    /**
     * Register a new user
     */
    public boolean registerUser(String username, String password) {
        try {
            // Validate input
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("Username cannot be empty");
            }
            
            if (password == null || password.length() < 4) {
                throw new IllegalArgumentException("Password must be at least 4 characters long");
            }
            
            // Check if user already exists
            if (dataBase.userExists(username.trim())) {
                throw new IllegalArgumentException("Username already exists");
            }
            
            // Create new user with hashed password
            String hashedPassword = PasswordUtils.hashPassword(password);
            User newUser = new User(username.trim(), hashedPassword);
            
            // Save to database
            dataBase.saveUser(newUser);
            logger.log(Level.INFO, "New user registered: {0}", username);
            
            return true;
            
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, "Failed to register user: {0} - {1}", new Object[]{username, e.getMessage()});
            throw new RuntimeException(e.getMessage());
        }
    }
    
    /**
     * Check if a username already exists
     */
    public boolean userExists(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        return dataBase.userExists(username.trim());
    }
}