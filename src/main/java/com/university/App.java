package com.university;

import com.university.models.University;
import com.university.utils.IO;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Submit1();
    }


    @Deprecated
    private static void Submit1() {
        IO io = new IO(1);

        University university = new University("Universidad Austral");

        List<String> result = io.readInputFile();

        result.removeFirst();
        for (String x : result) {
            university.registerRow1(x);
        }

        List<String> studentList = university.getStudentsAsString();
        studentList.addFirst("Student_Name,Course_Count");

        io.writeOutputList(studentList);
    }

    private static void Submit2() {
        IO io = new IO(2);

        University university = new University("Universidad Austral");

        List<String> result = io.readInputFile();

        result.removeFirst();
        for (String x : result) {
            university.registerRow2(x);
        }

        List<String> studentList = university.getGradesList();
        studentList.addFirst("Subject_Name,Evaluation_Name,Student_Name,Grade");

        io.writeOutputList(studentList);
    }
}
