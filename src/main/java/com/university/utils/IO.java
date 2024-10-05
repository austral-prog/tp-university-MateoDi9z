package com.university.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class IO {
    public static final String solutionFilePath1 = "src/main/resources/solution.csv";
    public static final String solutionFilePath2 = "src/main/resources/solution_2.csv";

    public static final String inputFilePath1 = "src/main/resources/input.csv";
    public static final String inputFilePath2 = "src/main/resources/input_2.csv";

    // IN USE
    private String actualSolutionFilepath = "";
    private String actualInputFilepath = "";

    public IO(Integer version) {
        switch (version) {
            case 1:
                this.actualSolutionFilepath = solutionFilePath1;
                this.actualInputFilepath = inputFilePath1;
                break;
            case 2:
                this.actualSolutionFilepath = solutionFilePath2;
                this.actualInputFilepath = inputFilePath2;
                break;
        }

        deleteFile(this.getSolutionFilePath());
    }

    // Getters
    public String getSolutionFilePath() { return actualSolutionFilepath; }
    public String getInputFilePath() { return actualInputFilepath; }

    // Pre-made
    public List<String> readInputFile() { return readFile(this.actualInputFilepath); }

    /**
     * Reads a CSV file and returns a List of strings
     * @return List of strings of the rows
     */
    public List<String> readFile(String filePath) {
        try (BufferedReader InputReader = new BufferedReader(new FileReader(filePath))) {
            String inputLine;
            List<String> inputList = new ArrayList<>();

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
    public void createOutputFile() {
        try {
            File solutionFile = new File(actualSolutionFilepath);

            if (solutionFile.createNewFile()) {
                System.out.println("File created: " + solutionFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Writes a String as a single line in the output file
     * @param output Output String
     */
    public void writeOutput(String output) {
        try {
            this.createOutputFile();
            FileWriter writer = new FileWriter(actualSolutionFilepath);

            writer.write(output + "\n");

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes a list of Strings as multiple lines in the output file
     * @param outputList Output String List
     */
    public void writeOutputList(List<String> outputList) {
        try {
            this.createOutputFile();
            FileWriter writer = new FileWriter(actualSolutionFilepath);

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
     * @param filePath File Path
     */
    public static void deleteFile(String filePath) {
        File myObj = new File(filePath);

        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
