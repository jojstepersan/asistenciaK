package com.example.jojstepersan.asistenciak.entities;

import java.util.List;

/**
 * Created by jojstepersan on 9/29/17.
 */

public class Student {
    private String name;
    private long code;
    private String program;
    private String lastName;

    private List<Assistance> assistances;
    private List<Materia> materias;


    public Student(String name, long code, String program, String lastName) {
        this.name = name;
        this.code = code;
        this.program = program;
        this.lastName = lastName;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public List<Assistance> getAssistances() {
        return assistances;
    }

    public void setAssistances(List<Assistance> assistances) {
        this.assistances = assistances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
