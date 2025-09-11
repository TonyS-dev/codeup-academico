/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academico.domain;
/**
 *
 * @author tonys-dev
 */
public class Grade {
    private final double value;

    public Grade(double value) {
        validateGrade(value);
        this.value = value;
    }

    public static void validateGrade(double grade) {
        if (grade < 0 || grade > 5) {
            throw new IllegalArgumentException("Grades must be between 0 and 5.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }


    public double getValue() { return value; }   
}