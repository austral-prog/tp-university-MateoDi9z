package com.university.models.Course;

public class Exercise {
    private String name;
    private Integer grade;

    public Exercise(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }

    public Exercise(String name) {
        this.name = name;
        this.grade = null;
    }

    // Getters
    public String getName() { return name; }
    public Integer getGrade() { return grade; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setGrade(Integer grade) { this.grade = grade; }
}
