/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academico.domain;

/**
 *
 * @author tonys-dev
 */
public class Student {
    private String name;
    private String lastName;
    private final int age;
    private String email;
    private String document;

    private final double grade1, grade2, grade3;

    private void validateGrades(double grade) {
        if (grade < 0 || grade > 5) throw new IllegalArgumentException("Invalid grade");
    }

    private void validateEmpty(String name, int age) {
        if (name == null) throw new IllegalArgumentException("Name is required");
        if (age <= 0) throw new IllegalArgumentException("Invalid age");
    }

    public double calculateAverage() {
        return Math.round((grade1 + grade2 + grade3) / 3 * 10.0) / 10.0;
    }

    public double getHighestGrade() {
        return Math.max(grade1, Math.max(grade2, grade3));
    }

    public boolean isApproved() {
        return calculateAverage() >= 3;
    }

    public Student(String name, int age, double grade1, double grade2, double grade3) {
        validateEmpty(name, age);
        validateGrades(grade1);
        validateGrades(grade2);
        validateGrades(grade3);

        this.name = name;
        this.age = age;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", document='" + document + '\'' +
                '}';
    }

}