package com.university.models;

import com.university.models.Course.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() throws Exception {
        this.student = new Student("Mateo");
        this.student = new Student("Mateo", "mateo@gmail");
    }

    @Test
    public void testAddGetCourses() {
        assertEquals(0, student.getCourseCount());
        student.addCourse(new Course(1, "Prog", student, new Professor("Brunito")));
        student.addCourse(new Course(2, "Prog", student, new Professor("Bauti")));
        student.addCourse(new Course(3, "Futbol", student, new Professor("Brunito")));
        assertEquals(2, student.getCourseCount());
    }

    @Test
    public void testGetters() {
        assertEquals(0, student.getCourseCount());
        student.addCourse(new Course(4, "Futbol", student, new Professor("Brunito")));
        assertEquals("mateo@gmail", student.getEmail());
        assertEquals(1, student.getCourses().size());
    }

    @Test
    public void testSetEmail() {
        assertEquals("mateo@gmail", student.getEmail());
        student.setEmail("mateo@gmail.com");
        assertEquals("mateo@gmail.com", student.getEmail());
    }

    @Test
    public void testToString() {
        assertEquals("Mateo,0", student.toString());
        this.student.addCourse(new Course(1, "Prog", student, new Professor("Brunito")));
        assertEquals("Mateo,1", student.toString());
    }

    @Test
    public void testEquals() {
        Student student2 = new Student("Bruno");
        Student student3 = student2;
        assertFalse(student.equals(student2));
        assertTrue(student2.equals(student3));
        assertFalse(student.equals(new Object()));
        assertTrue(student.equals(new Student("Mateo")));
    }
}
