package com.university.cli;

import com.university.CRUDRepository;

// Controllers
import com.university.Entity;
import com.university.controllers.StudentController;

// Models

import com.university.utils.ConsoleIO;

import javax.xml.stream.events.EntityReference;
import java.nio.file.attribute.AclEntryType;
import java.util.ArrayList;
import java.util.List;

public class CommandLineInterfaceHandler implements CLI {
    private final List<CRUDRepository<?>> repositories = new ArrayList<>();
    ConsoleIO io;

    public CommandLineInterfaceHandler() {
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
        this.io = new ConsoleIO();

        System.out.println("Bienvenidos al C L I !");
        for (CRUDRepository<?> repo : crudInterfaces) {
            System.out.println("Repositorio cargado: " + repo.getIdentifier());
        }

        while (true) {
            if (showMenu()) {
                break;
            }
        }
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
                // Create Menu

                break;
            case 3:
                // Update Menu
                break;
            case 4:
                // Delete Menu
                break;
            case 5:
                return true;
        }

        return false;
    }

    // READ
    private void GetMenu() {
        int i = 1;
        System.out.println("Seleccione una Entidad:");

        for (CRUDRepository<?> repo : this.repositories) {
            System.out.printf(" - %d - %s%n", i, repo.getIdentifier());
        }

        Integer entity = askOption(2);
        if (entity == null) { return; }

        System.out.println("Seleccione una Opción:");
        System.out.println("1 - Listar registros");
        System.out.println("2 - Ver un registro");
        System.out.println("3 - Volver");

        Integer option = askOption(3);
        if (option == null || option == 3) { return; }

        CRUDRepository<?> repo = this.repositories.get(entity-1);

        if (option == 1) {
            Entity result = repo.read(1);
            System.out.flush();
            if (result == null) System.out.println("Ningun registro encontrado.");

            for (int j = 1; j < 5; j++) {
                result = repo.read(j+1);
                if (result == null) continue;
                System.out.println(result);
            }
        } else if (option == 2) {
            Integer ID = askNumber("ID:");
            Entity result = repo.read(ID);

            if (result == null) {
                System.out.println("Not found");
                return;
            }

            System.out.println(result);
        }
    }

    private Integer askNumber(String prefix) {
        String read = io.readLine(prefix);
        try {
            return Integer.parseInt(read);
        } catch (NumberFormatException e) {
            System.out.println("Introduzca un numero.");
            return null;
        }
    }

    private Integer askOption(Integer limit) {
        String read = io.readLine(">");

        try {
            int readInt = Integer.parseInt(read);
            if (readInt < 1 || readInt > limit) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return readInt;
        } catch (NumberFormatException e) {
            System.out.println("Introduzca un numero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("El numero no tiene ninguna función asociada.");
        }
        return null;
    }
}
