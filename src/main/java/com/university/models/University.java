package com.university.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {
    String universityName;

    List<Student> students;
    List<Course> courses;
    List<Professor> professors;

    public University(String name) {
        this.universityName = name;

        this.students = new ArrayList<Student>();
        this.courses = new ArrayList<Course>();
        this.professors = new ArrayList<Professor>();

        System.out.println(" -> Created University named: " + universityName);
    }

    // Getters
    public List<Student> getStudents() {
        students.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        return students;
    }
    public List<Course> getCourses() { return courses; }
    public List<Professor> getProfessors() { return professors; }

    public String getName() { return universityName; }

    /**
     * Receives a String containing register the Course that a Student has and
     * creates instances if not exists.
     * @param row
     */
    public void registerRow(String row) {
        String[] data = row.split(",");

        Integer classroom = Integer.parseInt(data[0]);
        String subject = data[1],
                studentName = data[2],
                studentEmail = data[3],
                professorName = data[4];

        Professor professor = this.createProfessor(new Professor(professorName));
        Course course = this.createCourse(new Course(classroom, subject, professor));
        this.createStudentOrAddCourse(new Student(studentName, studentEmail), course);
    }

    /**
     * Returns a List of the students and courseCount in alphabetic order.
     * @return List["Name,CourseCount"]
     */
    public List<String> getStudentsAsString() {
        List<String> result = new ArrayList<>();
        for (Student student : this.students) {
            result.add(student.toString());
        }
        Collections.sort(result);
        return result;
    }

    // Methods
    public void createStudentOrAddCourse(Student student, Course course) {
        int idx = students.indexOf(student);
        if (idx == -1) {
            students.add(student);
            idx = students.indexOf(student);
            students.get(idx).addCourse(course);
        }
        else students.get(idx).addCourse(course);
    }

    public Professor createProfessor(Professor professor) {
        if (!professors.contains(professor)) professors.add(professor);
        return professor;
    }

    public Course createCourse(Course course) {
        if (!courses.contains(course)) courses.add(course);
        return course;
    }
}