package com.university.cliapp;

import com.university.CRUDRepository;

// Controllers
import com.university.controllers.StudentController;

// Models
import com.university.models.Student;

import java.util.ArrayList;
import java.util.List;

public class CommandLineInterfaceHandler implements CLI {
    public CommandLineInterfaceHandler() {
        final List<CRUDRepository<?>> repositories = new ArrayList<>();

        StudentController studentController = new StudentController();
        repositories.add(studentController);

        runCLI(repositories.toArray(new CRUDRepository<?>[0]));
    }

    /**
     * @param crudInterfaces an array of CRUDInterface instances, each representing a different entity type.
     *                       Each CRUDInterface allows the CLI to perform Create, Read, Update, and Delete
     *                       operations on that specific entity type.
     */
    @Override
    public void runCLI(CRUDRepository<?>[] crudInterfaces) {
        System.out.println("Bienvenidos al C L I !");

        for (CRUDRepository<?> repo : crudInterfaces) {
            System.out.println("Repositorio cargado: " + repo.getIdentifier());
        }
    }
}
