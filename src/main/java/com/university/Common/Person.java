package com.university.Common;

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // Getters
    public String getName() { return name; }

    // Setters
    public void setName(String name) { this.name = name; }
}
