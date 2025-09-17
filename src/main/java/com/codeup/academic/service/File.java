/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeup.academic.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.codeup.academic.domain.Grade;
import com.codeup.academic.domain.Student;
/**
 *
 * @author tonys-dev
 */
public class File {
    public static void exportCsv(List<Student> students, java.io.File file) {
        try {
            if (students.isEmpty()) {
                throw new IllegalArgumentException("The students list cannot be empty");
            }
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Id,Name,Age,Grade1,Grade2,Grade3\n");
                for (Student student : students) {
                    writer.write(String.format("%s,%s,%d,%.1f,%.1f,%.1f%n",
                            student.getId(),
                            student.getName(),
                            student.getAge(),
                            student.getGrades().get(0).getValue(),
                            student.getGrades().get(1).getValue(),
                            student.getGrades().get(2).getValue()));
                }
            }
        } catch (IOException ex) {
            System.getLogger(File.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public static List<Student> importCsv(java.io.File file) throws IllegalArgumentException, IOException {
        if (!file.getName().toLowerCase().endsWith(".csv") || !file.canRead() || !file.exists()) {
            throw new IllegalArgumentException("File not found or inaccessible");
        }

        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 6) {
                    throw new IllegalArgumentException("There is a problem with the file format. \nError found in this line: " + line + "\nPlease make sure each line has 6 items separated by commas.");
                }
                try {
                    UUID id = UUID.fromString(fields[0]);
                    String name = fields[1];
                    int age = Integer.parseInt(fields[2]);
                    List<Grade> grades = new ArrayList<>();
                    grades.add(new Grade(Double.parseDouble(fields[3])));
                    grades.add(new Grade(Double.parseDouble(fields[4])));
                    grades.add(new Grade(Double.parseDouble(fields[5])));

                    Student student = new Student(
                            id,
                            name,
                            age,
                            grades
                    );

                    students.add(student);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("There was a problem reading this line: \"" + line + "\". \nPlease check that all values are correct and formatted properly. \nDetails: " + e.getMessage());
                }
            }
        }
        return students;
    }
}
