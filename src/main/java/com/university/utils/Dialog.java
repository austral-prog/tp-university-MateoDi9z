package com.university.utils;

import com.university.CRUDRepository;
import com.university.common.Entities;

import java.util.List;

import static com.university.cli.CommandLineInterfaceHandler.getIO;

public abstract class Dialog {
    public static Integer askOption(Integer limit) {
        String read = getIO().readLine(">");

        try {
            int readInt = Integer.parseInt(read);
            if (readInt < 1 || readInt > limit) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return readInt;
        } catch (NumberFormatException e) {
            System.out.println("Introduzca un numero.");
            return askOption(limit);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("El numero no tiene ninguna función asociada.");
            return askOption(limit);
        } catch (StackOverflowError e) {
            return 1;
        }
    }

    public static Entities askEntity(List<CRUDRepository<?>> repos) {
        int i = 1;
        System.out.println("Seleccione una Entidad:");

        for (CRUDRepository<?> repo : repos) {
            System.out.printf(" - %d - %s%n", i++, repo.getIdentifier());
        }

        Integer option = askOption(repos.size());
        return Entities.values()[option-1];
    }

    public static String askInputString(String field) {
        return getIO().readLine(String.format(" %s: ", field));
    }

    public static Integer askNumber(String prefix) {
        String read = getIO().readLine(prefix);
        try {
            return Integer.parseInt(read);
        } catch (NumberFormatException e) {
            System.out.println("Introduzca un numero.");
            return askNumber(prefix);
        }
    }
}
