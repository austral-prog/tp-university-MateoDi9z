package com.university.models.Course.Evaluation;

import com.university.models.Course.Exercise;

import java.util.List;

public abstract class Evaluation {
    public enum EvaluationType {
        PRACTICAL_WORK,
        WRITTEN_EXAM,
        ORAL_EXAM,
        FINAL_PRACTICAL_WORK,
    }

    private String name;
    protected List<Exercise> exercises;

    // Getters
    public abstract EvaluationType getType();
    public String getName() { return name; }
    public List<Exercise> getExercises() { return exercises; }

    // Setters
    public void addExercise(Exercise exercise) { exercises.add(exercise); }
    public void setName(String name) { this.name = name; }

    public abstract float getGrade();

    public float getAverageGrade() {
        int i = 0;
        for (Exercise exercise : exercises) {
            i += exercise.getGrade();
        }
        return (float) i / exercises.size();
    }

    public Integer getMaxGrade() {
        int i = 0;
        for (Exercise exercise : exercises) {
            if (exercise.getGrade() > i) i = exercise.getGrade();
        }
        return i;
    }

    public Integer getMinGrade() {
        int i = exercises.getFirst().getGrade();
        for (Exercise exercise : exercises) {
            if (exercise.getGrade() < i) i = exercise.getGrade();
        }
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evaluation that = (Evaluation) o;
        return that.getName().equals(getName());
    }
}

// public Float getAverageGrade() {
//    Float result = 0.0f;
//    for (Exercise exercise : exercises) {
//        result += exercise.getGrade();
//    }
//    return result / exercises.size();
//
