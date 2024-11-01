package com.university.Models.Course.Evaluation;

import java.util.ArrayList;

public class PracticalWork extends Evaluation {
    public PracticalWork(String name) {
        this.setName(name);
        this.exercises = new ArrayList<>();
    }

    @Override
    public EvaluationType getType() { return EvaluationType.PRACTICAL_WORK; }

    @Override
    public float getGrade() {
        return this.exercises.getLast().getGrade();
    }
}
