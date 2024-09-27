package com.university;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() throws Exception {
        this.student = new Student("Mateo", "mateo@gmail");
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
