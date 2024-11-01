package com.university.utils;

import com.university.CRUDRepository;
import com.university.Entity;
import com.university.models.Entities;
import com.university.models.Student;

import java.util.List;

public abstract class Factory<T extends Entity> implements CRUDRepository<T> {
    public Entity create(Entities entity, List<String> params) throws Exception {
        switch (entity) {
            case Student:
                if (params.size() != Student.requiredParams) {
                    this.error();
                    return null;
                }
                return Serializer.serializeStudent(params);
            case Exercise:
                if (params.size() != Student.requiredParams) {
                    this.error();
                    return null;
                }
                return Serializer.serializeExercise(params);
            default:
                return null;
        }
    }

    void error() throws Exception {
        throw new Exception("Wrong params.");
    }
}
