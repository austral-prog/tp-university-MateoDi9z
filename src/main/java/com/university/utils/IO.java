package com.university.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class IO {
    private String solutionFilePath = "src/main/resources/solution.csv";
    // private String expectedFilePath = "src/main/resources/expected.csv";
    private String inputFilePath = "src/main/resources/input.csv";

    // Getters
    public String getSolutionFilePath() { return this.solutionFilePath; }
    public String getInputFilePath() { return this.inputFilePath; }

    /**
     * Reads a CSV file and returns a List of strings
     * @return List of strings of the rows
     */
    public List<String> readFile(String filePath) {
        try (BufferedReader InputReader = new BufferedReader(new FileReader(filePath))) {
            String inputLine;
            List<String> inputList = new ArrayList<String>();

            while ((inputLine = InputReader.readLine()) != null) {
                inputList.add(inputLine);
            }

            return inputList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Creates Output ("solution.csv") file.
     */
    public File createOutputFile() {
        try {
            File solutionFile = new File(solutionFilePath);

            if (solutionFile.createNewFile()) {
                System.out.println("File created: " + solutionFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            return solutionFile;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Writes a String as a single line in the output file
     * @param output
     */
    public void writeOutput(String output) {
        try {
            this.createOutputFile();
            FileWriter writer = new FileWriter(solutionFilePath);

            writer.write(output + "\n");

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes a list of Strings as multiple lines in the output file
     * @param outputList
     */
    public void writeOutputList(List<String> outputList) {
        try {
            this.createOutputFile();
            FileWriter writer = new FileWriter(solutionFilePath);

            for (String outputLine : outputList) {
                writer.write(outputLine + "\n");
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Delete a file from a specified filepath
     * @param filePath
     */
    public void deleteFile(String filePath) {
        File myObj = new File(filePath);

        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
