package br.com.agenda.model;

import java.util.Date;

public class Contacts {
    private int id;
    private String name;
    private int age;
    private Date date_resgister;

    //Getters and Setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate_resgister() {
        return date_resgister;
    }

    public void setDate_resgister(Date date_resgister) {
        this.date_resgister = date_resgister;
    }


}
