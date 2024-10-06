package com.university.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private Integer classroom;
    private String subject;
    private Professor professor;
    private List<Evaluation> evaluations;

    public Course(String subject) {
        this.subject = subject;
        this.classroom = null;
        this.professor = null;
        this.evaluations = new ArrayList<Evaluation>();
    }

    public Course(Integer classroom, String subject, Professor professor) {
        this.classroom = classroom;
        this.subject = subject;
        this.professor = professor;
        this.evaluations = new ArrayList<Evaluation>();
    }

    // Getters
    public Integer getClassroom() { return classroom; }
    public String getSubject() { return subject; }
    public Professor getProfessor() { return professor; }
    public List<Evaluation> getEvaluations() { return evaluations; }

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
        Map<String, List<Integer>> average = new HashMap<>();

        for (Evaluation evaluation : evaluations) {
            List<Integer> t = average.get(evaluation.getName());

            if (t == null) {
                average.put(evaluation.getName(), new ArrayList<>());
                t = average.get(evaluation.getName());
            }

            t.add(evaluation.getGrade());
        }

        for (Map.Entry<String, List<Integer>> entry : average.entrySet()) {
            Integer x = 0;
            for (Integer t : entry.getValue()) {
                x += t;
            }
            Float grade = (float) (x / entry.getValue().size());
            result.add(String.format("%s,%s,%s,%.1f", this.subject, entry.getKey(), studentName, grade));
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof Course cCourse)) { return false; }
        return this.getSubject().equals(cCourse.getSubject());
    }
}
