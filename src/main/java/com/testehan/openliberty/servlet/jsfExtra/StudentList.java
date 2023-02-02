package com.testehan.openliberty.servlet.jsfExtra;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class StudentList {

    private List<Student> students;

    public List<Student> fetchData(){
        students = new ArrayList<>();

        Student s1 = new Student();
        s1.setName("dan");
        s1.setGrade(10);

        Student s2 = new Student();
        s2.setName("loki");
        s2.setGrade(9);

        students.add(s1);
        students.add(s2);

        return students;
    }
}
