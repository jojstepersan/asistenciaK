package com.example.jojstepersan.asistenciak.entities;

import java.util.Date;

/**
 * Created by Valentina on 03/10/2017.
 */

public class Assistance {

    private Date date;
    private Student student;
    private boolean gone;

    public Assistance(Date date, Student student, boolean gone) {
        this.date = date;
        this.student = student;
        this.gone = gone;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isGone() {
        return gone;
    }

    public void setGone(boolean gone) {
        this.gone = gone;
    }
}
