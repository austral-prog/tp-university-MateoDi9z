package com.university.models;
import com.university.Entity;
import com.university.common.Person;

public class Professor extends Person  implements Entity {
    private Integer id;
    private static int idCounter = 0;

    public Professor(String name) {
        super(name);
        this.id = ++idCounter;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("- #%d %s", this.getId(), this.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Professor cProfessor)) {
            return false;
        }
        return this.getName().equals(cProfessor.getName());
    }
}
