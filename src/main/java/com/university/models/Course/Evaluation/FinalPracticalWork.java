package com.university.models.Course.Evaluation;

import java.util.ArrayList;

public class FinalPracticalWork extends Evaluation {
    public FinalPracticalWork(String name) {
        this.setName(name);
        this.exercises = new ArrayList<>();
    }

    @Override
    public EvaluationType getType() { return EvaluationType.FINAL_PRACTICAL_WORK; }

    @Override
    public float getGrate() {
        return 0; // TODO: Implement.
    }
}
