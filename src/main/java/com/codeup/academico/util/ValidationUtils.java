/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academico.util;

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
        if (isInRange(age, 1, 100)) {
            throw new IllegalArgumentException("Age must be between 1 and 100.");
        }
    }

    public static void validateGrades(Object[] gradesArr) {
        for (Object gradeObj : gradesArr) {
            String gradeStr = gradeObj.toString();
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