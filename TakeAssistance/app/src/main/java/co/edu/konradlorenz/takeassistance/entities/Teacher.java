package co.edu.konradlorenz.takeassistance.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentina on 03/10/2017.
 */

public class Teacher {
    private String name;
    private String lastName;
    private int id;
    private String email;
    private List<Class> classes;

    public Teacher(String name, String lastName, int id, String email) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        classes =new ArrayList<>();
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
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
