package com.university.models;

public class Evaluation {
    public enum EvaluationType {
        PRACTICAL_WORK,
        WRITTEN_EXAM,
        ORAL_EXAM,
        FINAL_PRACTICAL_WORK,
    }

    private EvaluationType type;
    private String name;
    private String exercise;
    private Integer grade;

    public Evaluation(EvaluationType type, String name, String exercise, Integer grade) {
        this.type = type;
        this.name = name;
        this.exercise = exercise;
        this.grade = grade;
    }

    // Getters
    public EvaluationType getType() { return type; }
    public String getName() { return name; }
    public String getExercise() { return exercise; }
    public Integer getGrade() { return grade; }
}
