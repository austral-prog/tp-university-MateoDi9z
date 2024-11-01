package com.university.CLI;

import com.university.CRUDRepository;
import com.university.Controllers.StudentController;
import com.university.Models.Student;

import java.util.ArrayList;
import java.util.List;

public class Runner implements CLI {
    private final List<CRUDRepository<?>> repositories = new ArrayList<>();

    public Runner() {
        CRUDRepository<Student> studentController = new StudentController();
        repositories.add(studentController);

        runCLI(repositories.toArray(new CRUDRepository<?>[0]));
    }

    @Override
    public void runCLI(CRUDRepository<?>[] crudInterfaces) {
        System.out.println("Bienvenidos al C L I !");


    }
}
