/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academico.domain;

import java.util.List;

/**
 *
 * @author tonys-dev
 */
public class Student {
    private final String id;
    private String name;
    private int age;
    private List<Grade> grades;


    public Student(String name, int age, List<Grade> grades) {
        this.id = java.util.UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}