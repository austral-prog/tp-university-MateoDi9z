package com.university.Models.Course.Evaluation;

import java.util.ArrayList;

public class OralExam extends Evaluation {
    public OralExam(String name) {
        this.setName(name);
        this.exercises = new ArrayList<>();
    }

    @Override
    public EvaluationType getType() { return EvaluationType.ORAL_EXAM; }

    @Override
    public float getGrade() {
        return this.exercises.getFirst().getGrade();
    }
}
