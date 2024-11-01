package com.university.utils;

import com.university.models.Course.Course;
import com.university.models.Course.Exercise;
import com.university.models.Student;

import java.util.List;

public abstract class Serializer {
    public static Student serializeStudent(List<String> params) {
        return new Student(params.get(0), params.get(1));
    }

    public static Course serializeCourse(List<String> params) {
        return new Course(params.get(0), new Student(params.get(1)));
    }

    public static Exercise serializeExercise(List<String> params) {
        return new Exercise(params.get(0), Integer.parseInt(params.get(1)));
    }
}
