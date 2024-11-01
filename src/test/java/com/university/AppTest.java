package com.university;

import com.university.utils.FileIO;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @AfterAll
    @BeforeAll
    public static void cleanUp() {
        FileIO.deleteFile("src/main/resources/solution.csv");
        FileIO.deleteFile("src/main/resources/solution_2.csv");
    }

    @Test
    public void testSolutionCSVMatchesExpected() {
        String solutionFilePath = "src/main/resources/solution.csv";
        String expectedFilePath = "src/main/resources/expected.csv";

        // Check if solution.csv exists before running the test
        if (Files.exists(Paths.get(solutionFilePath))) {
            fail("The solution.csv file exists before the test runs.");
        }

        try {
            App.main(new String[] { "1" }); // Running the App's main method
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to execute App.main()");
        }

        // Check if solution.csv was created after running the test
        if (!Files.exists(Paths.get(solutionFilePath))) {
            fail("The solution.csv file does not exist after running the test.");
        }

        // Proceed to compare the solution.csv with expected.csv
        try (BufferedReader solutionReader = new BufferedReader(new FileReader(solutionFilePath));
                BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFilePath))) {

            String solutionLine;
            String expectedLine;

            while ((solutionLine = solutionReader.readLine()) != null &&
                    (expectedLine = expectedReader.readLine()) != null) {
                assertEquals(expectedLine, solutionLine, "Mismatch found in the CSV file content.");
            }

            // Ensure both files have the same number of lines
            assertEquals(solutionReader.readLine(), expectedReader.readLine(), "Files have different number of lines.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
//    @Disabled
    public void testSolutionCSVMatchesExpected2() {
        String solutionFilePath = "src/main/resources/solution_2.csv";
        String expectedFilePath = "src/main/resources/expected_2.csv";

        Path path = Paths.get(solutionFilePath);

        // Check if solution.csv exists before running the test
        if (Files.exists(path)) {
            fail("The solution_2.csv file exists before the test runs.");
        }

        try {
            App.main(new String[] { "2" }); // Running the App's main method
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to execute App.main()");
        }

        // Check if solution.csv was created after running the test
        if (!Files.exists(path)) {
            fail("The solution.csv file does not exist after running the test.");
        }

        // Proceed to compare the solution.csv with expected.csv
        try (BufferedReader solutionReader = new BufferedReader(new FileReader(solutionFilePath));
                BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFilePath))) {

            String solutionLine;
            String expectedLine;

            while ((solutionLine = solutionReader.readLine()) != null &&
                    (expectedLine = expectedReader.readLine()) != null) {
                assertEquals(expectedLine, solutionLine, "Mismatch found in the CSV file content.");
            }

            // Ensure both files have the same number of lines
            assertEquals(solutionReader.readLine(), expectedReader.readLine(), "Files have different number of lines.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Este test checkea que los .csv sean IGUALS pero sin tener
     * en cuenta el orden de estos, buscando linea a linea la
     * existencia de esta en el otro archivo.
     */
    @Test
    @Disabled
    public void fixedTestSolutionCSVMatchesExpected2() {
        String solutionFilePath = "src/main/resources/solution_2.csv";
        String expectedFilePath = "src/main/resources/expected_2.csv";
        Path path = Paths.get(solutionFilePath);

        // Check if solution.csv exists before running the test
        if (Files.exists(path)) {
            fail("The solution.csv file exists before the test runs.");
        }

        try {
            App.main(new String[] { "2" }); // Running the App's main method
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to execute App.main()");
        }

        // Check if solution.csv was created after running the test
        if (!Files.exists(path)) {
            fail("The solution.csv file does not exist after running the test.");
        }

        // Proceed to compare the solution.csv with expected.csv
        try (BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFilePath));
                BufferedReader sr = new BufferedReader(new FileReader(solutionFilePath));) {
            String solutionLine;
            String expectedLine;

            while ((expectedLine = expectedReader.readLine()) != null) {
                BufferedReader solutionReader = new BufferedReader(new FileReader(solutionFilePath));
                while ((solutionLine = solutionReader.readLine()) != null) {
                    if (solutionLine.equals(expectedLine)) {
                        break;
                    }
                }

                assertEquals(expectedLine, solutionLine, "Mismatch found in the CSV file content.");
                solutionReader.close();
            }

            // Ensure both files have the same number of lines
            assertEquals(sr.readLine(), expectedReader.readLine(), "Files have different number of lines.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
