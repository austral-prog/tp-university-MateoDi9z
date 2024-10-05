package com.university.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.university.models.Evaluation.EvaluationType;
import static com.university.utils.Column.*;

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
     * (Classroom,Subject,Student_Name,Student_Email,Subject_Teacher)
     * Receives a String containing a Course that a Student has and
     * creates instances if not exists.
     * @param row
     */
    @Deprecated
    public void registerRow1(String row) {
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
     * (Student,Subject,Evaluation_Type,Evaluation_Name,Exercise_Name,Grade)
     * Receives a String containing register the Course that a Student has and
     * creates instances if not exists.
     * @param row
     */
    public void registerRow2(String row) {
        String[] data = row.split(",");

        Student student = new Student(data[STUDENT.ordinal()]);
        Course course = new Course(data[SUBJECT.ordinal()]);

        this.createStudentOrAddCourse(student, course);

        EvaluationType evaluationType = EvaluationType.valueOf(data[EVALUATION_TYPE.ordinal()]);

        Evaluation evaluation = new Evaluation(
                evaluationType,
                data[EVALUATION_NAME.ordinal()],
                data[EXERCISE_NAME.ordinal()],
                Integer.parseInt(data[GRADE.ordinal()])
        );

        course.addEvaluation(evaluation);
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

    public List<String> getGradesList() {
        List<String> result = new ArrayList<>();

        for (Student student : this.students) {
            for (Course course : student.getCourses()) {
                result.addAll(course.Serialize(student.getName()));
            }
        }
        Collections.sort(result);
        return result;
    }

    // Methods
    public void createStudentOrAddCourse(Student student, Course course) {
        int idx = students.indexOf(student);

        // Check if already exists
        if (idx >= 0) {
            students.get(idx).addCourse(course);
            return;
        }

        students.add(student);                  // Add student to list
        idx = students.indexOf(student);        // Get index
        students.get(idx).addCourse(course);    // Add Course
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