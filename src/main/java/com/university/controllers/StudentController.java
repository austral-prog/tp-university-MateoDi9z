package com.university.controllers;

import com.university.CRUDRepository;
import com.university.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentController implements CRUDRepository<Student> {
    private final List<Student> students;

    public StudentController() {
        this.students = new ArrayList<>();
    }

    /**
     * @param entity the entity to be created
     */
    public void create(Student entity) throws RuntimeException {
        students.add(entity);
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

            System.out.println("Student updated");
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
        };

        students.removeIf(student -> student.getId() == id);
        System.out.println("Student Removed Successfully");
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
