package com.university.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() throws Exception {
        this.student = new Student("Mateo", "mateo@gmail");
    }

    @Test
    public void testGetCourseCount() {
        assertEquals(0, student.getCourseCount());
        student.addCourse(new Course(1, "Prog", new Professor("Brunito")));
        student.addCourse(new Course(2, "Prog", new Professor("Bauti")));
        student.addCourse(new Course(3, "Futbol", new Professor("Brunito")));
        assertEquals(2, student.getCourseCount());
    }

/*    @Test
    public void testParser() {
        String[] data = Student.parser("349,Economics,Sam Pink,sam.pink@email.com,Prof. Quincy");

        assertEquals(data[0], "349");
        assertEquals(data[1], "Economics");
        assertEquals(data[2], "Sam Pink");
        assertEquals(data[3], "sam.pink@email.com");
        assertEquals(data[4], "Prof. Quincy");
    }*/
}
