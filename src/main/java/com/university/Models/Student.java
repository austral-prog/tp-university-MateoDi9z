package com.university.Models;

import com.university.Entity;
import com.university.Common.Person;
import com.university.Models.Course.Course;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Entity {
    private String email;
    private final List<Course> courses;
    private Integer id;

    public static final int requiredParams = 2;

    static Integer idCounter = 0;

    public Student(String name, String email) {
        super(name);
        this.id = ++idCounter;
        this.email = email;
        this.courses = new ArrayList<>();
    }

    public Student(String name) {
        super(name);
        this.id = ++idCounter;
        this.email = "";
        this.courses = new ArrayList<>();
    }

    // Getters
    public Integer getCourseCount() {
        int i = 0;
        List<String> subjects = new ArrayList<>();

        for (Course c : this.courses) {
            if (subjects.contains(c.getSubject())) continue;
            subjects.add(c.getSubject());
            i += 1;
        }
        return i;
    }

    public List<Course> getCourses() {
        return this.courses;
    }
    public String getEmail() {
        return email;
    }

    // Setters
    public void addCourse(Course course) {
        int idx = courses.indexOf(course);
        if (idx >= 0) return;
        this.courses.add(course);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Other
    @Override
    public String toString() {
        return String.format("%s,%d", super.getName(), this.getCourseCount());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Student cStudent)) {
            return false;
        }
        return this.getName().equals(cStudent.getName());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}