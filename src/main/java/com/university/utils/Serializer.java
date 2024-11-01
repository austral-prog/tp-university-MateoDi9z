package com.university.utils;

import com.university.models.Student;

import java.util.List;

public abstract class Serializer {
    public static Student serialize(List<String> params) {
        return new Student(params.get(0), params.get(1));
    }
}
