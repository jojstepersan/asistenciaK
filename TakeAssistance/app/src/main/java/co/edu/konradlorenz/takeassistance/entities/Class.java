package co.edu.konradlorenz.takeassistance.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojstepersan on 9/26/17.
 */

public class Class {

    private int id;
    private String name;
    private int group;
    private Teacher teacher;
    private List<Student> students;

    public Class(int id, String name, int group) {
        this.id = id;
        this.name = name;
        this.group = group;
        students=new ArrayList<>();
    }

    public Class(){}

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

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
