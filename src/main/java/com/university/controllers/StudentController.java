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
        if (students.contains(entity)) {
            throw new RuntimeException("Student already exists");
        }

        students.add(entity);
    }

    /**
     * @param id the unique identifier of the entity to be read
     * @return
     */
    @Override
    public Student read(int id) {
        return students
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
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

        oldStudent.setName(entity.getName());
        oldStudent.setEmail(entity.getEmail());
        oldStudent.setId(entity.getId());
    }

    /**
     * @param id the unique identifier of the entity to be deleted
     */
    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    /**
     * @return
     */
    @Override
    public String getIdentifier() {
        return "Student";
    }

    /**
     * @return
     */
    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}