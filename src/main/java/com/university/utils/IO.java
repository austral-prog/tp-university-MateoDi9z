package com.university.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class IO {
    private final List<String> solutionFiles = List.of(
            "src/main/resources/solution.csv",
            "src/main/resources/solution_2.csv",
            "src/main/resources/solution_3.csv"
    );
    private final List<String> inputFiles = List.of(
            "src/main/resources/input.csv",
            "src/main/resources/input_2.csv",
            "src/main/resources/input_3.csv"
    );

    // IN USE
    private Integer actualSolutionFilepathIdx = 0;
    private Integer actualInputFilepathIdx = 0;

    public IO(Integer version) {
        setFiles(version - 1);
        deleteFile(this.getSolutionFilePath());
    }

    // Getters
    public String getSolutionFilePath() { return solutionFiles.get(actualSolutionFilepathIdx); }
    public String getInputFilePath() { return inputFiles.get(actualInputFilepathIdx); }

    // Pre-made
    public List<String> readInputFile() { return readFile(this.inputFiles.get(actualInputFilepathIdx)); }

    public void setFiles(Integer version) {
        if (version <= 0 || version > 3) return;
        this.actualSolutionFilepathIdx = version;
        this.actualInputFilepathIdx = version;
    }

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
            printError(e);
            return null;
        }
    }

    /**
     * Creates Output ("solution.csv") file.
     */
    public void createOutputFile() {
        try {
            File solutionFile = new File(this.getSolutionFilePath());

            if (solutionFile.createNewFile()) {
                System.out.println("File created: " + solutionFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            printError(e);
        }
    }

    /**
     * Writes a String as a single line in the output file
     * @param output Output String
     */
    public void writeOutput(String output) {
        try {
            this.createOutputFile();
            FileWriter writer = new FileWriter(this.getSolutionFilePath());

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
            FileWriter writer = new FileWriter(this.getSolutionFilePath());

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

    private void printError(IOException e) { System.out.println(e.getMessage()); }
}
