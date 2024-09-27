package com.university;

import com.university.utils.IO;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        IO io = new IO();
        University university = new University("Universidad Austral");
        io.deleteFile(io.getSolutionFilePath());

        List<String> result = io.readFile(io.getInputFilePath());

        result.removeFirst();
        for (String x : result) {
            university.registerRow(x);
        }

        // Show results
        // studentManager.printStudentList();

        List<String> studentList = university.getStudentsAsString();
        studentList.addFirst("Student_Name,Course_Count");
        //System.out.println(studentList.get(1));
        io.writeOutputList(studentList);

        //Student x = university.getStudents().get(1);
    }
}
