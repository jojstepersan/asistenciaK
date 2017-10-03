package com.example.jojstepersan.asistenciak.entities;

import java.util.List;

/**
 * Created by Valentina on 03/10/2017.
 */

public class Teacher {
    private String name;
    private String lastName;
    private int id;
    private String email;
    private List<Materia> materias;

    public Teacher(String name, String lastName, int id, String email) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;

        this.email = email;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
