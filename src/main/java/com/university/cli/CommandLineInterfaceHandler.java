package com.university.cli;

import com.university.CRUDRepository;

// Controllers
import com.university.Entity;
import com.university.controllers.*;

import com.university.common.Entities;
import com.university.utils.ConsoleIO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.university.utils.Dialog.*;

public class CommandLineInterfaceHandler implements CLI {
    private List<CRUDRepository<?>> repositories = new ArrayList<>();
    private static ConsoleIO io;

    public CommandLineInterfaceHandler() {
        CRUDRepository<?>[] repos = new CRUDRepository<?>[5];
        repos[Entities.STUDENT.ordinal()] = new StudentController();
        repos[Entities.PROFESSOR.ordinal()] = new ProfessorController();
        repos[Entities.COURSE.ordinal()] = new CourseController();
        repos[Entities.EXERCISE.ordinal()] = new ExerciseController();
        repos[Entities.CRITERIA.ordinal()] = new CriteriaController();
        runCLI(repos);
    }

    // Singleton Console Input Output
    public static ConsoleIO getIO() {
        if (io == null) {
            io = new ConsoleIO();
        }
        return io;
    }

    /**
     * @param crudInterfaces an array of CRUDInterface instances, each representing a different entity type.
     *                       Each CRUDInterface allows the CLI to perform Create, Read, Update, and Delete
     *                       operations on that specific entity type.
     */
    @Override
    public void runCLI(CRUDRepository<?>[] crudInterfaces) {
        this.repositories = new ArrayList<>(List.of(Arrays.stream(crudInterfaces).toArray(CRUDRepository<?>[]::new)));

        System.out.println("Bienvenidos al C L I !");
        for (CRUDRepository<?> repo : crudInterfaces) {
            System.out.println("Repositorio cargado: " + repo.getIdentifier());
        }

        do { System.out.println(" "); } while (!showMenu());
    }

    private boolean showMenu() {
        System.out.println("Elija una opción:");
        System.out.println("1. Listar registros");
        System.out.println("2. Crear registro");
        System.out.println("3. Modificar registro");
        System.out.println("4. Eliminar registro");
        System.out.println("5. Salir");

        Integer option = askOption(5);

        if (option == null) return false;

        switch (option) {
            case 1:
                GetMenu();
                break;
            case 2:
                CreateMenu();
                break;
            case 3:
                UpdateMenu();
                break;
            case 4:
                DeleteMenu();
                break;
            case 5:
                return true;
        }

        return false;
    }

    // C - CREATE
    private void CreateMenu() {
        Entities entity = askEntity(this.repositories);
        CRUDRepository<?> repo = this.repositories.get(entity.ordinal());

        List<String> params = getParams(repo.getEntityClass());
        List<String> values = new ArrayList<>();

        for (String param : params) {
            values.add(askInputString(param));
        }

        repo.createWithParams(values);
    }

    // R - READ
    private void GetMenu() {
        Entities entity = askEntity(this.repositories);

        System.out.println("Seleccione una Opción:");
        System.out.println("1 - Listar registros");
        System.out.println("2 - Ver un registro");
        System.out.println("3 - Volver");

        Integer option = askOption(3);

        CRUDRepository<?> repo = this.repositories.get(entity.ordinal());

        if (option == 3) return;

        if (option == 1) {  // Read All
            List<? extends Entity> result = repo.readAll();

            if (result.isEmpty()) {
                System.out.println("Ningún registro encontrado.");
                return;
            }

            for (Entity entities : result) {
                System.out.println(entities.toString());
            }
            return;
        }

        // Read one
        Integer ID = askNumber("ID:");
        Entity result = repo.read(ID);

        if (result == null) {
            System.out.println("Not found");
            return;
        }

        System.out.println(result);
    }

    // U - UPDATE
    private void UpdateMenu() {
        Entities entity = askEntity(this.repositories);
        CRUDRepository<?> repo = getRepo(entity);

        List<String> params = getParams(repo.getEntityClass());
        List<String> values = new ArrayList<>();

        for (String param : params) {
            values.add(askInputString(param));
        }

        repo.updateWithParams(values);
    }

    // D - DELETE
    private void DeleteMenu() {
        Entities entity = askEntity(this.repositories);
        CRUDRepository<?> repo = getRepo(entity);

        Integer ID = askNumber("ID:");
        repo.delete(ID);
    }

    private CRUDRepository<?> getRepo(Entities entity) {
        return this.repositories.get(entity.ordinal());
    }

    private List<String> getParams(Class<? extends Entity> clase) {
        Field[] campos = clase.getDeclaredFields();
        List<String> parameters = new ArrayList<>();

        for (Field campo : campos) {
            if (!(campo.getType().getSimpleName().equals("Integer")) &&
                    !(campo.getType().getSimpleName().equals("String"))) continue;
            parameters.add(campo.getName());
        }

        return parameters;
    }
}
