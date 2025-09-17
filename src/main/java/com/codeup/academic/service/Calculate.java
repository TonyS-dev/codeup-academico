/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academic.service;

import java.util.List;

import com.codeup.academic.domain.Grade;

/**
 *
 * @author tonys-dev
 */
public class Calculate {
    public static double Average(List<Grade> grades) {
        return Math.round(grades.stream().mapToDouble(Grade::getValue).average().orElse(0.0) * 10.0) / 10.0;
    }
    public static Grade HighestGrade(List<Grade> grades) {
        return new Grade(grades.stream().mapToDouble(Grade::getValue).max().orElse(0.0));
    }
    public static boolean Approved(List<Grade> grades) {
        return Average(grades) >= 3.0;
    }
}