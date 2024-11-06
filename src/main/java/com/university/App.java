package com.university;

import com.university.cli.CommandLineInterfaceHandler;
import com.university.models.University;
import com.university.utils.FileIO;

import java.util.List;
import java.util.Objects;


public class App {
    public static void main(String[] args) {
        if (args.length != 0) {
            System.out.printf("Found argument: %s%n", args[0]);

            if (Objects.equals(args[0], "1")) Submit1();
            if (Objects.equals(args[0], "2")) Submit2();
        }

        System.out.println("No arguments given, CLI mode ON!");
        CommandLineInterfaceHandler handler = new CommandLineInterfaceHandler();
    }

    private static void Submit1() {
        FileIO fileIo = new FileIO(1);

        University university = new University("Universidad Austral");

        List<String> result = fileIo.readInputFile();

        result.removeFirst();
        for (String x : result) {
            university.registerRow1(x);
        }

        List<String> studentList = university.getStudentsAsString();
        studentList.addFirst("Student_Name,Course_Count");

        fileIo.writeOutputList(studentList);
    }

    private static void Submit2() {
        FileIO fileIo = new FileIO(2);

        University university = new University("Universidad Austral");

        List<String> result = fileIo.readInputFile();

        result.removeFirst();
        for (String x : result) {
            university.registerRow2(x);
        }

        List<String> studentList = university.getGradesList();
        studentList.addFirst("Subject_Name,Evaluation_Name,Student_Name,Grade");

        fileIo.writeOutputList(studentList);
    }
}
