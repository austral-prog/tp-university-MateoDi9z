package com.university.utils.fileStructure;

import com.university.CRUDRepository;
import com.university.common.Entities;
import com.university.controllers.CourseController;
import com.university.controllers.ProfessorController;
import com.university.controllers.StudentController;
import com.university.models.Course.Course;
import com.university.models.Course.Exercise;
import com.university.models.Professor;
import com.university.models.Student;

public class Input1 extends InputFile {
    public Integer classroom;
    public String subject,
            studentName,
            studentEmail,
            professorName;

    public enum Columns {
        CLASSROOM,
        SUBJECT,
        STUDENT,
        STUDENT_EMAIL,
        PROFESSOR_NAME,
    }

    public Input1(String row) {
        String[] data = row.split(",");

        classroom = Integer.parseInt(data[Columns.CLASSROOM.ordinal()]);
        subject = data[Columns.SUBJECT.ordinal()];
        studentName = data[Columns.STUDENT.ordinal()];
        studentEmail = data[Columns.STUDENT_EMAIL.ordinal()];
        professorName = data[Columns.PROFESSOR_NAME.ordinal()];
    }

    public void register(CRUDRepository<?>[] repos) {
        CRUDRepository<Student> studentRepo = (StudentController) repos[Entities.STUDENT.ordinal()];
        CRUDRepository<Course> courseRepo = (CourseController) repos[Entities.COURSE.ordinal()];
        CRUDRepository<Professor> professorRepo = (ProfessorController) repos[Entities.PROFESSOR.ordinal()];

        int studentId = studentRepo.create(new Student(this.studentName, this.studentEmail));
        int professorId = professorRepo.create(new Professor(this.professorName));

        Course course = new Course(
                this.classroom,
                this.subject,
                studentRepo.read(studentId),
                professorRepo.read(professorId)
        );

        int courseId = courseRepo.create(course);

        studentRepo.read(studentId).addCourse(courseRepo.read(courseId));
    }
}
