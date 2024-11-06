package com.university.models.Course;

import com.university.models.Course.Evaluation.Evaluation;
import com.university.models.Professor;
import com.university.models.Student;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private Integer classroom;
    private String subject;
    private Professor professor;
    private final Student student;
    private final List<Evaluation> evaluations;

    public Course(String subject, Student student) {
        this.subject = subject;
        this.classroom = null;
        this.professor = null;
        this.student = student;
        this.evaluations = new ArrayList<>();
    }

    public Course(Integer classroom, String subject, Student student, Professor professor) {
        this.classroom = classroom;
        this.subject = subject;
        this.professor = professor;
        this.student = student;
        this.evaluations = new ArrayList<>();
    }

    // Getters
    public Integer getClassroom() { return classroom; }
    public String getSubject() { return subject; }
    public Professor getProfessor() { return professor; }
    public List<Evaluation> getEvaluations() { return evaluations; }
    public Student getStudent() { return student; }

    // Setters
    public void setClassroom(Integer classroom) { this.classroom = classroom; }
    public void setClassroom(String classroom) { this.classroom = Integer.parseInt(classroom); }
    public void setSubject(String subject) { this.subject = subject; }
    public void addEvaluation(Evaluation evaluation) {
        evaluations.add(evaluation);
    }
    public void setProfessor(Professor professor) { this.professor = professor; }

    public List<String> Serialize(String studentName) {
        List<String> result = new ArrayList<>();

        for (Evaluation evaluation : evaluations) {
            result.add(String.format("%s,%s,%s,", this.subject, evaluation.getName(), studentName) + evaluation.getGrade());
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof Course cCourse)) { return false; }
        return (this.getSubject().equals(cCourse.getSubject()))
                && (this.getStudent().equals(cCourse.getStudent()));
    }
}
