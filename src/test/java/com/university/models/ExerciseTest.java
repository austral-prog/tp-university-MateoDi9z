package com.university.models;

import com.university.models.Course.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseTest {

    private Exercise exerciseWithGrade;
    private Exercise exerciseWithoutGrade;

    @BeforeEach
    void setUp() {
        this.exerciseWithGrade = new Exercise("Math", 90);
        this.exerciseWithoutGrade = new Exercise("Science");
    }

    @Test
    void testConstructorWithGrade() {
        assertEquals("Math", exerciseWithGrade.getName());
        assertEquals(90, exerciseWithGrade.getGrade());
    }

    @Test
    void testConstructorWithoutGrade() {
        assertEquals("Science", exerciseWithoutGrade.getName());
        assertNull(exerciseWithoutGrade.getGrade());
    }

    @Test
    void testSetName() {
        exerciseWithGrade.setName("Physics");
        assertEquals("Physics", exerciseWithGrade.getName());
    }

    @Test
    void testSetGrade() {
        exerciseWithoutGrade.setGrade(85);
        assertEquals(85, exerciseWithoutGrade.getGrade());
    }

    @Test
    void testSetNullGrade() {
        exerciseWithGrade.setGrade(null);
        assertNull(exerciseWithGrade.getGrade());
    }
}