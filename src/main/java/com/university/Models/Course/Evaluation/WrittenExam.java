package com.university.Models.Course.Evaluation;

import com.university.Models.Course.Exercise;

import java.util.ArrayList;

public class WrittenExam extends Evaluation {
    public WrittenExam(String name) {
        this.setName(name);
        this.exercises = new ArrayList<>();
    }

    @Override
    public EvaluationType getType() { return EvaluationType.WRITTEN_EXAM; }

    @Override
    public float getGrade() {
        float nota = 0.0f;
        for (Exercise exercise : exercises) {
            nota += exercise.getGrade();
        }
        return nota / exercises.size();
    }
}
