package com.university.models.Course.Evaluation;

import java.util.ArrayList;

public class WrittenExam extends Evaluation {
    public WrittenExam(String name) {
        this.setName(name);
        this.exercises = new ArrayList<>();
    }

    @Override
    public EvaluationType getType() { return EvaluationType.WRITTEN_EXAM; }

    @Override
    public float getGrate() {
        return 0; // TODO: Implement.
    }
}
