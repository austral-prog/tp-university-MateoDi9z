package com.university.utils;

import com.university.models.Course.Evaluation.EvaluationType;

import static com.university.utils.Column.*;

public class Row2 {
    public String studentName,
                    subject,
                    evaluationType,
                    evaluationName,
                    exerciseName;

    public Integer grade;

    public Row2(String row) {
        String[] data = row.split(",");

        studentName = data[STUDENT.ordinal()];
        subject = data[SUBJECT.ordinal()];
        evaluationType = data[EVALUATION_TYPE.ordinal()];
        evaluationName = data[EVALUATION_NAME.ordinal()];
        exerciseName = data[EXERCISE_NAME.ordinal()];
        grade = Integer.parseInt(data[GRADE.ordinal()]);
    }

    public EvaluationType getEvaluationType() {
        return EvaluationType.valueOf(evaluationType);
    }
}
