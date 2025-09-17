/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academic.util;

import java.util.List;

import com.codeup.academic.domain.Grade;
import com.codeup.academic.domain.Student;

/**
 *
 * @author tonys-dev
 */
public class ValidationUtils {
    private ValidationUtils() {}

    public static void validateName(String name) {
        if (isEmptyOrNull(name)) {
            throw new IllegalArgumentException("Name must be filled out.");
        }
        if (isOnlyDigits(name)) {
            throw new IllegalArgumentException("Name cannot include numbers.");
        }
    }

    public static void validateAge(Object ageObj) {
        if (ageObj == null) throw new IllegalArgumentException("Age must be filled out.");
        int age;
        try {
            age = Integer.parseInt(ageObj.toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Age must be a number.");
        }
        if (isInRange(age, 1, 120)) {
            throw new IllegalArgumentException("Age must be between 1 and 120.");
        }
    }

    public static void validateGrades(List<Grade> grades) {
        if (grades == null || grades.isEmpty()) {
            throw new IllegalArgumentException("Grades list cannot be empty.");
        }
        if (grades.size() != 3) {
            throw new IllegalArgumentException("Exactly 3 grades are required.");
        }
        for (Grade grade : grades) {
            if (grade == null) {
                throw new IllegalArgumentException("All grades must be filled out.");
            }
            double value = grade.getValue();
            if (value < 0 || value > 5) {
                throw new IllegalArgumentException("Grades must be between 0 and 5.");
            }
        }
    }

    public static void validateStrGrades(String[] gradeStrings) {
        if (gradeStrings == null || gradeStrings.length != 3) {
            throw new IllegalArgumentException("Exactly 3 grades are required.");
        }
        for (String gradeStr : gradeStrings) {
            if (isEmptyOrNull(gradeStr)) {
                throw new IllegalArgumentException("All Grades must be filled out.");
            }
            if (isOnlyLetters(gradeStr)) {
                throw new IllegalArgumentException("Grades cannot include letters.");
            }
            double grade;
            try {
                grade = Double.parseDouble(gradeStr);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Grades must be numbers.");
            }
            if (grade < 0 || grade > 5) {
                throw new IllegalArgumentException("Grades must be between 0 and 5.");
            }
        }
    }

    public static void validateStudents(List<Student> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("Student list must not be empty.");
        }
        for (Student student : students) {
            validateName(student.getName());
            validateAge(student.getAge());
            validateGrades(student.getGrades());
        }
    }

    public static boolean isEmptyOrNull(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isOnlyLetters(String str) {
        return str.chars().allMatch(Character::isLetter);
    }

    public static boolean isOnlyDigits(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean isInRange(int number, int min, int max) {
        return (number < min || number > max);
    }
}