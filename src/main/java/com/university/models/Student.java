package com.university.models;

import com.university.Entity;
import com.university.common.Person;
import com.university.models.Course.Course;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Entity {
    private Integer id;
    private String email;
    private final List<Course> courses;

    public static final int requiredParams = 2;

    static Integer idCounter;

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

    @Override
    public int getId() { return id; }

    // Setters
    public void addCourse(Course course) {
        int idx = courses.indexOf(course);
        if (idx >= 0) return;
        this.courses.add(course);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setId(int id) { this.id = id; }

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
}