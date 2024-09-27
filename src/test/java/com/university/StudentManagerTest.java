package com.university;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentManagerTest {
    private StudentManager studentManager;

    @BeforeEach
    public void setUp() throws Exception {
        this.studentManager = new StudentManager();
    }

    @Test
    public void testAddAndGetStudent() {
        studentManager.addStudent(new Student("Mateo", "mateo@gmail"));
        List<Student> students = studentManager.getStudentList();

        assertNotNull(students);
        assertEquals(1, students.size());
        assertEquals("Mateo", students.getFirst().getName());
        assertEquals("mateo@gmail", students.getFirst().getEmail());
    }
}
