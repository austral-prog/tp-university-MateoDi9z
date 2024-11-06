package com.university.models.Course;

import com.university.Entity;

public class Exercise implements Entity {
    private Integer id;
    private String name;
    private Integer grade;

    private static int idCounter = 0;

    public Exercise(String name, Integer grade) {
        this.id = ++idCounter;
        this.name = name;
        this.grade = grade;
    }

    public Exercise(String name) {
        this.id = ++idCounter;
        this.name = name;
        this.grade = null;
    }

    // Getters
    public String getName() { return name; }
    public Integer getGrade() { return grade; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setGrade(Integer grade) { this.grade = grade; }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("- #%d - %s | Grade: %s", this.getId(), this.getName(), this.getGrade());
    }
}
