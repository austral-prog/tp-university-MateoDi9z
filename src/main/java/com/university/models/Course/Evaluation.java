package com.university.models.Course;

import java.util.ArrayList;
import java.util.List;

public class Evaluation {
    public enum EvaluationType {
        PRACTICAL_WORK,
        WRITTEN_EXAM,
        ORAL_EXAM,
        FINAL_PRACTICAL_WORK,
    }

    private String name;
    private EvaluationType type;
    private final List<Exercise> exercises;

    public Evaluation(EvaluationType type, String name) {
        this.name = name;
        this.type = type;
        this.exercises = new ArrayList<>();
    }

    // Getters
    public EvaluationType getType() { return type; }
    public String getName() { return name; }
    public List<Exercise> getExercises() { return exercises; }

    // Setters
    public void addExercise(Exercise exercise) { exercises.add(exercise); }
    public void setName(String name) { this.name = name; }
    public void setType(EvaluationType type) { this.type = type; }

    public Float getAverageGrade() {
        Float result = 0.0f;
        for (Exercise exercise : exercises) {
            result += exercise.getGrade();
        }
        return result / exercises.size();
    }
}
