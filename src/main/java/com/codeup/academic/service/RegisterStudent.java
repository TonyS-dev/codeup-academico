/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academic.service;

import java.util.ArrayList;
import java.util.List;

import com.codeup.academic.domain.Student;

/**
 *
 * @author tonys-dev
 */
public class RegisterStudent {

    private final static List<Student> students = new ArrayList<>();

    public static void addStudent(Student e) {
        Student student = new Student(e.getId(), e.getName(), e.getAge(), e.getGrades());
        students.add(student);
    }
    public static List<Student> getStudents() {
        return students;
    }
    public static double calculateAverage(List<Student> students) {
        double total = 0.0;
        for (Object student : students) {
            total += Calculate.Average(((Student) student).getGrades());
        }
        return Math.round((total / students.size()) * 10.0) / 10.0;
    }
    public static String getBestStudents(List<Student> students) {
        double maxAverage = students.stream()
                .mapToDouble(student -> calculateAverage(List.of(student)))
                .max()
                .orElse(Double.NaN);

        if (Double.isNaN(maxAverage)) {
            return "";
        }

        return students.stream()
                .filter(student -> calculateAverage(List.of(student)) == maxAverage)
                .map(Student::toString)
                .reduce((s1, s2) -> s1 + ", " + s2)
                .orElse("");
    }
    public static long countApproved(List<Student> students) {
        return students.stream()
                .filter(s -> Calculate.Approved(s.getGrades()))
                .count();
    }
    public static long countFailed(List<Student> students) {
        return students.stream()
                .filter(s -> !Calculate.Approved(s.getGrades()))
                .count();
    }

}
