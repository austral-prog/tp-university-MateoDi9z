package com.university.models;

import com.university.models.Course.Course;
import com.university.models.Course.Evaluation.Evaluation;
import com.university.models.Course.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.university.models.Course.Evaluation.Evaluation.EvaluationType.FINAL_PRACTICAL_WORK;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    private Course course;
    private Course fullCourse;

    @BeforeEach
    public void setUp() throws Exception {
        this.course = new Course("Math", new Student("Mateo"));
        this.fullCourse = new Course(5, "Excel", new Student("Mateo"), new Professor("Bruno"));
    }

    @Test
    public void testSetGetClassroom() {
        assertNull(course.getClassroom());
        this.course.setClassroom(1);
        assertEquals(1, course.getClassroom());
        assertEquals(5, fullCourse.getClassroom());
        this.course.setClassroom("2");
        this.fullCourse.setClassroom("3");
        assertEquals(2, course.getClassroom());
        assertEquals(3, fullCourse.getClassroom());
    }

    @Test
    public void testSetGetSubject() {
        assertEquals("Math", course.getSubject());
        assertEquals("Excel", fullCourse.getSubject());
        this.course.setSubject("English");
        this.fullCourse.setSubject("Math");
        assertEquals("English", course.getSubject());
        assertEquals("Math", fullCourse.getSubject());
    }

    @Test
    public void testSetGetProfessor() {
        assertNull(course.getProfessor());
        assertEquals("Bruno", fullCourse.getProfessor().getName());
        this.course.setProfessor(new Professor("Mateo"));
        this.fullCourse.setProfessor(new Professor("Mateo"));
        assertEquals("Mateo", course.getProfessor().getName());
        assertEquals("Mateo", fullCourse.getProfessor().getName());
    }

    @Test
    public void testSetGetEvaluations() {
        assertEquals(new ArrayList<>(), course.getEvaluations());
        assertEquals(new ArrayList<>(), fullCourse.getEvaluations());
        Evaluation evaluation = new Evaluation(FINAL_PRACTICAL_WORK, "Tp 2");
        evaluation.addExercise(new Exercise("ej 1", 7));
        course.addEvaluation(evaluation);
        fullCourse.addEvaluation(evaluation);
        assertEquals(1, course.getEvaluations().size());
        assertEquals(1, fullCourse.getEvaluations().size());
    }

    @Test
    public void testEquals() {
        // Course course1 = new Course("Math II");
        assertNotEquals(course, fullCourse);
        this.course.setSubject("Math");
        this.fullCourse.setSubject("Math");
        assertEquals(course, course);
        assertNotEquals(course, new Object());
        assertEquals(course, fullCourse);
    }
}
