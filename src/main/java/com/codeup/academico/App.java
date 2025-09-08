/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.codeup.academico;

import com.codeup.academico.domain.Course;
import com.codeup.academico.domain.Student;

/**
 *
 * @author tonys-dev
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Academic System CodeUp initialized correctly!");
        Course course = new Course("1", "Mathematics");
        Student student = new Student("1", "Juan Pablo");
        System.out.println(course.getName());
        System.out.println(student.getName());
    }
}
