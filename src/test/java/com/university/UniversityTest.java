package com.university;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityTest {
    private University university;

    @BeforeEach
    public void setUp() throws Exception {
        this.university = new University("Universidad Austral");
    }

    @Test
    public void testUniversityAttr() {
        assertEquals("Universidad Austral", university.getName());
        assertEquals(new ArrayList<Student>(), university.getStudents());
        assertEquals(new ArrayList<Professor>(), university.getProfessors());
        assertEquals(new ArrayList<Course>(), university.getCourses());
    }
}
