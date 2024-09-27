package com.university;

import com.university.utils.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IOTest {

    private IO reader;

    @BeforeEach
    public void setUp() throws Exception {
        this.reader = new IO();
    }

    @Test
    public void testReadInput() {
        List<String> result = this.reader.readFile(this.reader.getInputFilePath());

        assertNotNull(result);
        assertEquals("Classroom,Subject,Student_Name,Student_Email,Subject_Teacher", result.get(0));
        assertEquals("578,Political Science,Olivia Red,olivia.red@student.org,Prof. Sam", result.get(1));
    }

    @Test
    public void testDeleteFile() {
        this.reader.deleteFile(this.reader.getSolutionFilePath());
        List<String> result = this.reader.readFile(this.reader.getSolutionFilePath());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testWriteOutputFile() {
        this.reader.deleteFile(this.reader.getSolutionFilePath());

        this.reader.writeOutput("Hola!!");
        List<String> result = this.reader.readFile(this.reader.getSolutionFilePath());

        assertEquals(1, result.size());
        assertEquals("Hola!!", result.getFirst());

        this.reader.deleteFile(this.reader.getSolutionFilePath());

    }
}
