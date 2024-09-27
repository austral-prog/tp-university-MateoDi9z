package com.university;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<Student>();
    }

    // Getters
    public List<Student> getStudentList() { return studentList; }

    public List<String> getStudentListAsString() {
        List<String> result = new ArrayList<>();
        for (Student student : studentList) {
            result.add(student.toString());
        }
        return result;
    };

    // Setters
    public Student addStudent(Student student) {
        if (!studentList.contains(student)) studentList.add(student);
        return student;
    }

    // Methods

    public void addStudentUnparsed(String inlineStudent) {
        String[] studentData = Student.parser(inlineStudent);
        Student student = new Student(studentData[2], studentData[3]);

        if (this.studentList.contains(student)) {
            this.studentList.get(this.studentList.indexOf(student)).addCourse();
        };
        this.addStudent(student);
    }

    public void printStudentList() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
