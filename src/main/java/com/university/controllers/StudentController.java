package com.university.controllers;

import com.university.CRUDRepository;
import com.university.models.Course.Evaluation.Evaluation;
import com.university.models.Criteria;
import com.university.models.Student;
import com.university.models.Course.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StudentController implements CRUDRepository<Student> {
    private final List<Student> students;

    public StudentController() {
        this.students = new ArrayList<>();
    }

    @Override
    public int create(Student entity) {
        Student found = this.students.stream()
                .filter(x ->
                        Objects.equals(x.getName(), entity.getName())
                ).findFirst()
                .orElse(null);

        if (found != null) {
            return found.getId();
        }

        students.add(entity);
        return entity.getId();
    }

    @Override
    public void createWithParams(List<String> params) {
        Student student = new Student("", params.get(1));
        try {
            int id = Integer.parseInt(params.getFirst());
            if (id <= 0) throw new NumberFormatException("Invalid ID");

            student.setId(id);
            this.create(student);

            System.out.println("Student Created Successfully");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }
    }

    /**
     * @param id the unique identifier of the entity to be read
     * @return found student
     */
    @Override
    public Student read(int id) {
        return students
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> readAll() {
        return students;
    }

    /**
     * @param id     the unique identifier of the entity to be updated
     * @param entity the updated entity information
     */
    @Override
    public void update(int id, Student entity) throws RuntimeException {
        Student oldStudent = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (oldStudent == null) {
            throw new RuntimeException("Student not found");
        }

//        oldStudent.setName(entity.getName());
        oldStudent.setEmail(entity.getEmail());
        oldStudent.setId(entity.getId());
    }

    @Override
    public void updateWithParams(List<String> params) {
        Student student = new Student("", params.get(1));

        try {
            int id = Integer.parseInt(params.getFirst());

            if (id <= 0) throw new NumberFormatException("Invalid ID");

            student.setId(id);
            this.update(id, student);

            System.out.println("Student updated Successfully");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        } catch (RuntimeException e) {
            System.out.println("Not found");
        }
    }

    /**
     * @param id the unique identifier of the entity to be deleted
     */
    @Override
    public void delete(int id) {
        if (id <= 0) {
            System.out.println("Invalid ID");
            return;
        }

        if (read(id) == null) {
            System.out.println("Student not found");
            return;
        }

        students.removeIf(student -> student.getId() == id);
        System.out.println("Student Removed Successfully");
    }

    /**
     * Returns a List of the students and courseCount in alphabetic order.
     * @return List["Name,CourseCount"]
     */
    public static List<String> getStudentsAsString(List<Student> students) {
        List<String> result = new ArrayList<>();
        for (Student student : students) {
            result.add(String.format("%s,%d", student.getName(), student.getCourseCount()));
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

    public List<String> getCareerHistory(CriteriaController criteriaRepo) {
        List<String> result = new ArrayList<>();

        for (Student student : this.students) {
            for (Course course : student.getCourses()) {
                String subject = course.getSubject();

                // Materia APROBADA
                Evaluation finalExam = course.getFinalExam();
                if (finalExam != null) {
                    Criteria criteriaApprove = criteriaRepo.findCriteria(subject, finalExam.getName());

                    if (criteriaApprove.getApprove(finalExam)) {
                        result.add(String.format("%s,%s,APROBADA", subject, student.getName()));
                        continue;
                    }
                }
//                Regular
//                Habilitado a redir
            }
        }

        return result;
    }

    @Override
    public String getIdentifier() {
        return "Student";
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
