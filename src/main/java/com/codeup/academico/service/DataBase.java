/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academico.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codeup.academico.domain.AccessLevel;
import com.codeup.academico.domain.User;
import com.codeup.academico.domain.UserRole;
import com.codeup.academico.util.PasswordUtils;

/**
 *
 * @author tonys-dev
 */
public class DataBase {
    private static final String DB_URL = "jdbc:sqlite:academico.db";
    private static final Logger logger = Logger.getLogger(DataBase.class.getName());
    
    public DataBase() {
        initializeDatabase();
    }
    
    private void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String createUsersTable = """
                CREATE TABLE IF NOT EXISTS users (
                    id TEXT PRIMARY KEY,
                    username TEXT UNIQUE NOT NULL,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL,
                    access_level TEXT NOT NULL,
                    created_at INTEGER NOT NULL,
                    updated_at INTEGER NOT NULL,
                    is_active INTEGER NOT NULL DEFAULT 1
                )
            """;
            
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createUsersTable);
                
                // Create default admin user if no users exist
                if (!hasAnyUsers()) {
                    createDefaultAdmin();
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error initializing database", e);
        }
    }
    
    private boolean hasAnyUsers() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM users")) {
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error checking for existing users", e);
        }
        return false;
    }
    
    private void createDefaultAdmin() {
        User defaultAdmin = new User("admin", PasswordUtils.hashPassword("admin123"));
        saveUser(defaultAdmin);
        logger.info("Default admin user created with username: admin, password: admin123");
    }

    public void saveUser(User user) {
        String sql = """
            INSERT INTO users (id, username, password, role, access_level, created_at, updated_at, is_active)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getRole().name());
            pstmt.setString(5, user.getAccessLevel().name());
            pstmt.setLong(6, user.getCreatedAt().getTime());
            pstmt.setLong(7, user.getUpdatedAt().getTime());
            pstmt.setInt(8, user.getIsActive() ? 1 : 0);
            
            pstmt.executeUpdate();
            logger.log(Level.INFO, "User saved successfully: {0}", user.getUsername());
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error saving user: " + user.getUsername(), e);
            throw new RuntimeException("Error saving user: " + e.getMessage());
        }
    }

    public User findUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ? AND is_active = 1";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User(rs.getString("username"), rs.getString("password"));
                    user.setId(UUID.fromString(rs.getString("id")));
                    user.setRole(UserRole.valueOf(rs.getString("role")));
                    user.setAccessLevel(AccessLevel.valueOf(rs.getString("access_level")));
                    user.setCreatedAt(new Date(rs.getLong("created_at")));
                    user.setUpdatedAt(new Date(rs.getLong("updated_at")));
                    user.setIsActive(rs.getInt("is_active") == 1);
                    return user;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error finding user: " + username, e);
        }
        
        return null;
    }
    
    public boolean userExists(String username) {
        return findUserByUsername(username) != null;
    }
}
