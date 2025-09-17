/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academic.domain;

/**
 *
 * @author tonys-dev
 */
public class Course {
    private final String id;
    private String name;

    public Course(String id, String name) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Id is required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}
