package com.university;

import com.university.cli.CommandLineInterfaceHandler;
import com.university.controllers.FileController;
import java.util.Objects;

import static com.university.controllers.FileController.*;


public class App {
    public static void main(String[] args) {
        FileController fc = new FileController();
        CRUDRepository<?>[] repos = fc.getRepos();

        if (args.length != 0) {
            System.out.printf("Found argument: %s%n", args[0]);

            if (Objects.equals(args[0], "1")) Submit1(repos);
            if (Objects.equals(args[0], "2")) Submit2(repos);
            if (Objects.equals(args[0], "3")) Submit3(repos);
            return;
        }

        System.out.println("No arguments given, CLI mode ON!");
        CommandLineInterfaceHandler handler = new CommandLineInterfaceHandler();
    }
}
