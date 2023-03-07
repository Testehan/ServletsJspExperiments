package com.testehan.openliberty.servlet.primeFaces;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class CoursesBean {

    private List<String> courses;

    @PostConstruct
    public void init(){
        courses = new ArrayList<>();
        courses.add("JSF");
        courses.add("REST API");
        courses.add("Mongo DB");
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
