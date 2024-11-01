package com.university.Models;

import com.university.Models.Course.Course;
import com.university.Models.Course.Evaluation.*;
import com.university.Models.Course.Exercise;
import com.university.utils.Row2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.university.Models.Course.Evaluation.Evaluation.EvaluationType;

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
    private Student addStudent(String studentName) {
        Student student = getStudent(studentName);
        if (student == null) {
            student = new Student(studentName);
            students.add(student);
        }
        return student;
    }

    private Course addCourse(String subject, Student student) {
        Course course = getCourse(subject, student);
        if (course == null) {
            course = new Course(subject, student);
            courses.add(course);
            student.addCourse(course);
        }
        return course;
    }

    /**
     * (Classroom,Subject,Student_Name,Student_Email,Subject_Teacher)
     * Receives a String containing a Course that a Student has and
     * creates instances if not exists.
     * @param row String with data
     */
    public void registerRow1(String row) {
        String[] data = row.split(",");

        Integer classroom = Integer.parseInt(data[0]);

        String subject = data[1],
                studentName = data[2],
                studentEmail = data[3],
                professorName = data[4];

        Student student = new Student(studentName, studentEmail);
        Professor professor = this.createProfessor(new Professor(professorName));
        Course course = this.createCourse(new Course(classroom, subject, student, professor));
        this.createStudentOrAddCourse(student, course);
    }

    /**
     * (Student,Subject,Evaluation_Type,Evaluation_Name,Exercise_Name,Grade)
     * Receives a String containing register the Course that a Student has and
     * creates instances if not exists.
     * @param row String with data
     */
    public void registerRow2(String row) {
        Row2 data = new Row2(row);

        Student student = addStudent(data.studentName);
        Course course = addCourse(data.subject, student);

        EvaluationType evaluationType = data.getEvaluationType();

        String evaluationName = data.evaluationName;
        String subject = data.subject;

        boolean found = false;
        Evaluation evaluation;

        switch (evaluationType) {
            case ORAL_EXAM -> evaluation = new OralExam(evaluationName);
            case FINAL_PRACTICAL_WORK -> evaluation = new FinalPracticalWork(evaluationName);
            case PRACTICAL_WORK -> evaluation = new PracticalWork(evaluationName);
            case WRITTEN_EXAM -> evaluation = new WrittenExam(evaluationName);
            default -> {
                return;
            }
        }

        for (Evaluation e : course.getEvaluations()) {
            if (e.equals(evaluation) && course.getSubject().equals(subject)) {
                evaluation = e;
                found = true;
                break;
            }
        }

        evaluation.addExercise(new Exercise(data.exerciseName, data.grade));

        if (found) return;
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
    public Student createStudentOrAddCourse(Student student, Course course) {
        int idx = students.indexOf(student);

        // Check if already exists
        if (idx >= 0) {
            students.get(idx).addCourse(course);
            return students.get(idx);
        }

        students.add(student);                  // Add student to list
        idx = students.indexOf(student);        // Get index
        students.get(idx).addCourse(course);    // Add Course

        return students.get(idx);
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