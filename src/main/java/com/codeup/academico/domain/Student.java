/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academico.domain;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author tonys-dev
 */
public class Student {
    private final UUID id;
    private String name;
    private int age;
    private List<Grade> grades;


    public Student(UUID id, String name, int age, List<Grade> grades) {
        this.id = id;
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

    public UUID getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return name;
    }
}