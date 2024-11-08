package com.university.controllers;

import com.university.CRUDRepository;
import com.university.models.Course.Course;
import com.university.models.Professor;
import com.university.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProfessorController implements CRUDRepository<Professor> {
    private final List<Professor> professors;

    public ProfessorController() {
        this.professors = new ArrayList<>();
    }

    @Override
    public int create(Professor entity) {
        Professor found = this.professors.stream()
                .filter(x ->
                        Objects.equals(x.getName(), entity.getName())
                ).findFirst()
                .orElse(null);

        if (found != null) {
            return found.getId();
        }

        professors.add(entity);
        return entity.getId();
    }

    @Override
    public void createWithParams(List<String> params) {
        Professor professor = new Professor("");

        try {
            int id = Integer.parseInt(params.getFirst());
            if (id <= 0) throw new NumberFormatException("Invalid ID");

            professor.setId(id);
            this.create(professor);

            System.out.println("Professor Created Successfully");
        } catch (RuntimeException e) {
            System.out.println("Invalid ID");
        }
    }

    /**
     * @param id the unique identifier of the entity to be read
     * @return found professor
     */
    @Override
    public Professor read(int id) {
        return professors
                .stream()
                .filter(professor -> professor.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Professor> readAll() { return professors; }

    /**
     * @param id     the unique identifier of the entity to be updated
     * @param entity the updated entity information
     */
    @Override
    public void update(int id, Professor entity) throws RuntimeException {
        Professor oldProfessor = professors.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (oldProfessor == null) {
            throw new RuntimeException("Student not found");
        }

//        oldStudent.setName(entity.getName());
        oldProfessor.setId(entity.getId());
        System.out.println("Professor Updated Successfully");
    }

    @Override
    public void updateWithParams(List<String> params) {
        Professor professor = new Professor("");

        try {
            int id = Integer.parseInt(params.getFirst());

            if (id <= 0) throw new NumberFormatException("Invalid ID");

            professor.setId(id);
            this.update(id, professor);

            System.out.println("Professor Updated Successfully");
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
            System.out.println("Professor not found");
            return;
        }

        professors.removeIf(student -> student.getId() == id);
        System.out.println("Professor Removed Successfully");
    }

    @Override
    public String getIdentifier() {
        return "Professor";
    }

    @Override
    public Class<Professor> getEntityClass() {
        return Professor.class;
    }
}
