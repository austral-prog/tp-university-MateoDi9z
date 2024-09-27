package com.university;

public class Student extends Person {
    private Integer courseCount;

    Student(String name, String email) {
        super(name, email);
        this.courseCount = 0;
    }

    // Getters
    public Integer getCourseCount() { return courseCount; }

    // Setters
    public void addCourse() { courseCount++; }

    public String toString() {
        return String.format("%s, %d", super.getName(), this.getCourseCount());
    }

    // UnParsed Student
    public static String[] parser(String unparsed) {
        return unparsed.trim().split(",");
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof Student cStudent)) { return false; }
        return this.getName().equals(cStudent.getName());
    }
}
