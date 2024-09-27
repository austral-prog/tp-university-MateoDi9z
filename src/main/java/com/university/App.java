package com.university;

import com.university.utils.IO;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        IO io = new IO();
        io.deleteFile(io.getSolutionFilePath());

        List<String> result = io.readFile(io.getInputFilePath());
        StudentManager studentManager = new StudentManager();

        result.removeFirst();
        for (String x : result) {
            studentManager.addStudentUnparsed(x);
        }

        // Show results
        // studentManager.printStudentList();

        List<String> studentList = studentManager.getStudentListAsString();
        studentList.addFirst("Student_Name,Course_Count");
        io.writeOutputList(studentList);
    }
}
