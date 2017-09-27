package com.example.jojstepersan.asistenciak.entities;

/**
 * Created by jojstepersan on 9/26/17.
 */

public class Materia {

    private int id;
    private String name;
    private int group;

    public Materia(int id, String name, int group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }
    public Materia(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
