package com.university.models;

public class Course {
    private Integer classroom;
    private String subject;
    private Professor professor;

    public Course(Integer classroom, String subject, Professor professor) {
        this.classroom = classroom;
        this.subject = subject;
        this.professor = professor;
    }

    // Getters
    public Integer getClassroom() { return classroom; }
    public String getSubject() { return subject; }

    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof Course cCourse)) { return false; }
        return this.getSubject().equals(cCourse.getSubject());
    }
}
