package com.university.models;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testRegisterRow() {
        String studentName = "Liam Magenta",
                profName = "Prof. Hank",
                classroom = "562";
        String example = classroom+",Mathematics,"+studentName+",liam.magenta@email.com,"+profName;

        this.university.registerRow1(example);

        assertEquals(1, university.getStudents().size());
        assertEquals(1, university.getProfessors().size());
        assertEquals(1, university.getCourses().size());

        assertEquals(studentName, university.getStudents().getFirst().getName());
        assertEquals(profName, university.getProfessors().getFirst().getName());
        assertEquals(Integer.parseInt(classroom), university.getCourses().getFirst().getClassroom());
    }

    @Test
    public void testGetStudentsAsString() {

        this.university.registerRow1("438,Psychology,Paul Black,paul.black@email.com,Prof. Jack");
        this.university.registerRow1("288,Anthropology,Charlie Beige,charlie.beige@student.org,Prof. Rita");
        this.university.registerRow1("339,Economics,Bob Cyan,bob.cyan@student.org,Prof. Dana");

        List<String> result = this.university.getStudentsAsString();

        assertEquals("Paul Black,1", result.getLast());
    }
}
