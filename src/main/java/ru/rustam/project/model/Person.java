package ru.rustam.project.model;

public class Person {
    private String name;
    private int yearOfBirth;
    private int id;

    public Person(String name, int yearOfBirth, int id) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.id = id;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
