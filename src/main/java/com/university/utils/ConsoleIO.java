package com.university.utils;

import java.util.Scanner;

public class ConsoleIO {
    private final Scanner scanner;
    public ConsoleIO() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine(String prefix) {
        System.out.print(prefix + " ");
        return scanner.nextLine();
    }
}
