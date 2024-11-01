package com.university;

import java.io.PrintStream;

public class App {
    public static void main(String[] args) {
        PrintStream x = System.out;
        x.println("Hola");


//        if (args.length == 0) {
//            System.out.println("No arguments given");
//            Submit1();
//            return;
//        }
//
//        System.out.printf("Found argument: %s%n", args[0]);
//
//        if (Objects.equals(args[0], "1")) Submit1();
//        if (Objects.equals(args[0], "2")) Submit2();
    }

//
//    @Deprecated
//    private static void Submit1() {
//        IO io = new IO(1);
//
//        University university = new University("Universidad Austral");
//
//        List<String> result = io.readInputFile();
//
//        result.removeFirst();
//        for (String x : result) {
//            university.registerRow1(x);
//        }
//
//        List<String> studentList = university.getStudentsAsString();
//        studentList.addFirst("Student_Name,Course_Count");
//
//        io.writeOutputList(studentList);
//    }
//
//    private static void Submit2() {
//        IO io = new IO(2);
//
//        University university = new University("Universidad Austral");
//
//        List<String> result = io.readInputFile();
//
//        result.removeFirst();
//        for (String x : result) {
//            university.registerRow2(x);
//        }
//
//        io = new IO(3);
//
//        List<String> studentList = university.getGradesList();
//        studentList.addFirst("Subject_Name,Evaluation_Name,Student_Name,Grade");
//
//        io.writeOutputList(studentList);
//    }
}
