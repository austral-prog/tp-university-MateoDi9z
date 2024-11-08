package com.university.models;

import com.university.models.Course.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.university.models.Course.Evaluation.Evaluation.EvaluationType;

public class University {
    String universityName;

    List<Student> students;
    List<Course> courses;
    List<Professor> professors;

    public University(String name) {
        this.universityName = name;

        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.professors = new ArrayList<>();

        System.out.println(" -> Created University named: " + universityName);
    }

    // ---------- Getters ----------
    public List<Student> getStudents() {
        students.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        return students;
    }
    public List<Course> getCourses() { return courses; }
    public List<Professor> getProfessors() { return professors; }

    public String getName() { return universityName; }

    // ---------- Finders ----------
    public Student getStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public Course getCourse(String subject, Student student) {
        for (Course course : courses) {
            if (course.equals(new Course(subject, student))) {
                return course;
            }
        }
        return null;
    }

    // ---------- Creators ----------
//    private Student addStudent(String studentName) {
//        Student student = getStudent(studentName);
//        if (student == null) {
//            student = new Student(studentName);
//            students.add(student);
//        }
//        return student;
//    }

//    private Course addCourse(String subject, Student student) {
//        Course course = getCourse(subject, student);
//        if (course == null) {
//            course = new Course(subject, student);
//            courses.add(course);
//            student.addCourse(course);
//        }
//        return course;
//    }

    /**
     * (Classroom,Subject,Student_Name,Student_Email,Subject_Teacher)
     * Receives a String containing a Course that a Student has and
     * creates instances if not exists.
     * @param row String with data
     */
//    public void registerRow1(String row) {
//        String[] data = row.split(",");
//
//        Integer classroom = Integer.parseInt(data[0]);
//
//        Input1 input1 = new Input1(data);
//
//        Student student = new Student(studentName, studentEmail);
//        Professor professor = this.createProfessor(new Professor(professorName));
//        Course course = this.createCourse(new Course(classroom, subject, student, professor));
//        this.createStudentOrAddCourse(student, course);
//    }

    // Methods
//    public Student createStudentOrAddCourse(Student student, Course course) {
//        int idx = students.indexOf(student);
//
//        // Check if already exists
//        if (idx >= 0) {
//            students.get(idx).addCourse(course);
//            return students.get(idx);
//        }
//
//        students.add(student);                  // Add student to list
//        idx = students.indexOf(student);        // Get index
//        students.get(idx).addCourse(course);    // Add Course
//
//        return students.get(idx);
//    }
//
//    public Professor createProfessor(Professor professor) {
//        if (!professors.contains(professor)) professors.add(professor);
//        return professor;
//    }
//
//    public Course createCourse(Course course) {
//        if (!courses.contains(course)) courses.add(course);
//        return course;
//    }
}