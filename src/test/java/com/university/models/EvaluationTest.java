package com.university.models;

import com.university.models.Course.Evaluation.Evaluation;
import com.university.models.Course.Exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.university.models.Course.Evaluation.Evaluation.EvaluationType.*;
import static org.junit.jupiter.api.Assertions.*;

class EvaluationTest {

    private Evaluation evaluation;
    private Exercise exercise1;
    private Exercise exercise2;
    private Exercise exerciseWithoutGrade;

    @BeforeEach
    void setUp() {
        evaluation = new Evaluation(WRITTEN_EXAM, "Midterm Exam");
        exercise1 = new Exercise("Exercise 1", 80);
        exercise2 = new Exercise("Exercise 2", 90);
        exerciseWithoutGrade = new Exercise("Exercise 3");
    }

    @Test
    void testConstructor() {
        assertEquals("Midterm Exam", evaluation.getName());
        assertEquals(WRITTEN_EXAM, evaluation.getType());
        assertTrue(evaluation.getExercises().isEmpty());
    }

    @Test
    void testAddExercise() {
        evaluation.addExercise(exercise1);
        List<Exercise> exercises = evaluation.getExercises();

        assertEquals(1, exercises.size());
        assertEquals(exercise1, exercises.getFirst());
    }

    @Test
    void testAddMultipleExercises() {
        evaluation.addExercise(exercise1);
        evaluation.addExercise(exercise2);
        List<Exercise> exercises = evaluation.getExercises();

        assertEquals(2, exercises.size());
        assertEquals(exercise1, exercises.get(0));
        assertEquals(exercise2, exercises.get(1));
    }

    @Test
    void testSetName() {
        evaluation.setName("Final Exam");
        assertEquals("Final Exam", evaluation.getName());
    }

    @Test
    void testSetType() {
        evaluation.setType(Evaluation.EvaluationType.ORAL_EXAM);
        assertEquals(ORAL_EXAM, evaluation.getType());
    }

    @Test
    void testGetExercises() {
        evaluation.addExercise(exercise1);
        evaluation.addExercise(exercise2);
        List<Exercise> exercises = evaluation.getExercises();

        assertEquals(2, exercises.size());
    }

    @Test
    void testGetAverageGrade() {
        evaluation.addExercise(exercise1); // Grade 80
        evaluation.addExercise(exercise2); // Grade 90
        Float average = evaluation.getAverageGrade();

        assertEquals(85.0f, average); // (80 + 90) / 2 = 85
    }

    @Test
    void testGetAverageGradeWithNullGrades() {
        evaluation.addExercise(exerciseWithoutGrade); // Null grade
        evaluation.addExercise(exercise2); // Grade 90

        // Avoid NullPointerException by handling null grades (if needed in method)
        assertThrows(NullPointerException.class, evaluation::getAverageGrade);
    }
}