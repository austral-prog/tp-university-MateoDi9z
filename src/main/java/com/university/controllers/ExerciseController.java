package com.university.controllers;

import com.university.CRUDRepository;
import com.university.models.Course.Exercise;

import java.util.ArrayList;
import java.util.List;

public class ExerciseController implements CRUDRepository<Exercise> {
    private final List<Exercise> exercises;

    public ExerciseController() {
        this.exercises = new ArrayList<>();
    }

    /**
     * @param entity the entity to be created
     */
    public void create(Exercise entity) {
        exercises.add(entity);
    }

    @Override
    public void createWithParams(List<String> params) {
        try {
            Exercise exercise = new Exercise(params.get(1), Integer.parseInt(params.get(2)));

            int id = Integer.parseInt(params.getFirst());
            if (id <= 0) throw new NumberFormatException("Invalid ID");

            exercise.setId(id);
            this.create(exercise);

            System.out.println("Exercise Created Successfully");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }
    }

    /**
     * @param id the unique identifier of the entity to be read
     * @return found exercise
     */
    @Override
    public Exercise read(int id) {
        return exercises
                .stream()
                .filter(exercise -> exercise.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Exercise> readAll() {
        return exercises;
    }

    /**
     * @param id     the unique identifier of the entity to be updated
     * @param entity the updated entity information
     */
    @Override
    public void update(int id, Exercise entity) throws RuntimeException {
        Exercise oldExercise = exercises.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (oldExercise == null) {
            throw new RuntimeException("Exercise not found");
        }

//        oldExercise.setName(entity.getName());
        oldExercise.setName(entity.getName());
        oldExercise.setGrade(entity.getGrade());
        oldExercise.setId(entity.getId());
    }

    @Override
    public void updateWithParams(List<String> params) {
        try {
            Exercise exercise = new Exercise(params.get(1), Integer.parseInt(params.get(2)));

            int id = Integer.parseInt(params.getFirst());
            if (id <= 0) throw new NumberFormatException("Invalid ID");

            exercise.setId(id);
            this.update(id, exercise);

            System.out.println("Exercise updated Successfully");
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
            System.out.println("Exercise not found");
            return;
        }

        exercises.removeIf(exercise -> exercise.getId() == id);
        System.out.println("Exercise Removed Successfully");
    }

    @Override
    public String getIdentifier() {
        return "Exercise";
    }

    @Override
    public Class<Exercise> getEntityClass() {
        return Exercise.class;
    }
}
