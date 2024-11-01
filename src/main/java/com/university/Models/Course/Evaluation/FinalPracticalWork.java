package com.university.Models.Course.Evaluation;

import com.university.Models.Course.Exercise;

import java.util.ArrayList;

public class FinalPracticalWork extends Evaluation {
    public FinalPracticalWork(String name) {
        this.setName(name);
        this.exercises = new ArrayList<>();
    }

    @Override
    public EvaluationType getType() { return EvaluationType.FINAL_PRACTICAL_WORK; }

    @Override
    public float getGrade() {
        float nota = 0.0f;
        for (Exercise ex : this.exercises) {
            nota += ex.getGrade();
        }
//        if (nota > 50.0f) return nota / 10;
        return nota;
    }
}
