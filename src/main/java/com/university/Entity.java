package com.university;

public interface Entity {
    int getId();
    void setId(int id);

    /**
     * Printable format showing the data of an Entity
     * @return a readable text
     */
    String toString();
}
