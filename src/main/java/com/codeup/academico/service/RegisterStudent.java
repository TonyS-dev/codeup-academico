/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academico.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.codeup.academico.domain.Student;

/**
 *
 * @author tonys-dev
 */
public class RegisterStudent {

    private final static List<Student> students = new ArrayList<>();

    public static void addStudent(Student e) {
        Student student = new Student(e.getName(), e.getAge(), e.getGrades());
        students.add(student);
    }
    public static List<Student> listStudents() {
        return students;
    }
    public static double calculateAverage(List<Student> students, String studentId) {
        return Calculate.Average(students.stream()
                .filter(s -> s.getId().equals(studentId))
                .flatMap(s -> s.getGrades().stream())
                .collect(Collectors.toList()));
    }
    public static Optional<Student> bestStudent() {
        return students.stream()
                .max(Comparator.comparingDouble(s -> calculateAverage(students, s.getId())));
    }
    public static long countApproved() {
        return students.stream()
                .filter(s -> Calculate.Approved(s.getGrades()))
                .count();
    }
    public static long countFailed() {
        return students.stream()
                .filter(s -> !Calculate.Approved(s.getGrades()))
                .count();
    }

}
