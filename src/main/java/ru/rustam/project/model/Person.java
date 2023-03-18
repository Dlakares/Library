package ru.rustam.project.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class Person {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 ch")
    private String name;
    @Min(value = 1900, message = "Year of birth should not be over 1900 year")
    @NotEmpty(message = "name cant be empty")
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
